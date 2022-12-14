package de.htwg.se.ConnectFour.databaseComponent.MongoDB

import com.google.inject.Inject
import de.htwg.se.ConnectFour.databaseComponent.DAOInterface
import de.htwg.se.ConnectFour.model.gridComponent.{Cell, Piece}
import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Grid
import play.api.libs.json.{JsArray, JsValue, Json}
import org.mongodb.scala.*
import org.mongodb.scala.model.Updates.set
import org.mongodb.scala.model.Filters.*
import org.mongodb.scala.result.{DeleteResult, InsertOneResult, UpdateResult}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

/**
 * DAO MongoDB Extended Implementation. To see the difference in performance with a extravagantly solution.
 */
class DAOMongoDBImpl @Inject () extends DAOInterface:

  /** Init */
  val database_pw = sys.env.getOrElse("MONGO_INITDB_ROOT_PASSWORD", "mongo").toString
  val database_username = sys.env.getOrElse("MONGO_INITDB_ROOT_USERNAME", "root").toString

  val uri: String = s"mongodb://$database_username:$database_pw@localhost:27017/?authSource=admin"
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("ConnectFour")
  val gridCollection: MongoCollection[Document] = db.getCollection("grid")
  val playerCollection: MongoCollection[Document] = db.getCollection("player")
  val settingsCollection: MongoCollection[Document] = db.getCollection("settings")

  /** CREATE */
  override def create =
    val gridDocument: Document = Document("_id" -> "gridDocument")
    val player1Document: Document = Document("_id" -> "player1Document", "playerNum" -> 1, "playerName" -> "Player_1")
    val player2Document: Document = Document("_id" -> "player2Document", "playerNum" -> 2, "playerName" -> "Player_2")
    val settingsDocument: Document = Document("_id" -> "settingsDocument", "moveCount" -> 1, "currentPlayer" -> "Player_1",
    "xsize" -> 7, "ysize" -> 6)
    observerInsertion(gridCollection.insertOne(gridDocument))
    var count = 0
    for (cols <- 0 until 7) {
      for (rows <- 0 until 6) {
        observerInsertion(gridCollection.insertOne(Document("_id" -> count, "row" -> rows, "col" -> cols, "value" -> -1)))
        count += 1
      }
    }
    observerInsertion(playerCollection.insertOne(player1Document))
    observerInsertion(playerCollection.insertOne(player2Document))
    observerInsertion(settingsCollection.insertOne(settingsDocument))

  /** READ */
  override def read:Future[String] =
    val player1Document: Document = Await.result(playerCollection.find(equal("_id", "player1Document")).first().head(), Duration.Inf)
    val player2Document: Document = Await.result(playerCollection.find(equal("_id", "player2Document")).first().head(), Duration.Inf)
    val settingsDocument: Document = Await.result(settingsCollection.find(equal("_id", "settingsDocument")).first().head(), Duration.Inf)

    val player1 = player1Document("playerName").asString().getValue.toString
    val player2 = player2Document("playerName").asString().getValue.toString
    val player1Cell = Cell(Some(Piece(Player(player1, 1))))
    val player2Cell = Cell(Some(Piece(Player(player2, 2))))

    val moveCount = settingsDocument("moveCount").asInt32().getValue
    val currentPlayer = settingsDocument("currentPlayer").asString().getValue.toString

    var temp_grid = Grid(Vector.tabulate(6, 7) { (rowCount, col) => Cell(None) })

    for (x <- 0 until settingsDocument("xsize").asInt32().getValue * settingsDocument("ysize").asInt32().getValue) {
      val cellDocument = Await.result(gridCollection.find(equal("_id", x)).first().head(), Duration.Inf)
      val value = cellDocument("value").asInt32().getValue.toInt
      val row = cellDocument("row").asInt32().getValue.toInt
      val col = cellDocument("col").asInt32().getValue.toInt
      value match
        case 1 => temp_grid = temp_grid.replaceCell(row, col, player1Cell)
        case 2 => temp_grid = temp_grid.replaceCell(row, col, player2Cell)
        case _ => temp_grid = temp_grid.replaceCell(row, col, Cell(None))
    }
    Future(temp_grid.toJsonString(moveCount,currentPlayer,player1,player2))

  /** UPDATE */
  override def update(input:String) =
    val gameJson: JsValue = Json.parse(input)
    val moveCount = (gameJson \ "player" \ "moveCount" \ "value").get.toString().toInt
    val currentPlayer = (gameJson \ "player" \ "currentPlayer" \ "name").get.toString().toString
    val player1_json = (gameJson \ "player" \ "player1" \ "name").get.toString()
    val player2_json = (gameJson \ "player" \ "player2" \ "name").get.toString()
    val grid = (gameJson \ "grid")
    val cells = (grid \ "cells").as[JsArray]

    recUpdateGrid(cells, 0)

    Try({
      observerUpdate(gridCollection.updateOne(equal("_id","gridDocument"), set("_id","gridDocument")))
      observerUpdate(playerCollection.updateOne(equal("_id", "player1Document"), set("playerName", player1_json)))
      observerUpdate(playerCollection.updateOne(equal("_id", "player2Document"), set("playerName", player2_json)))
      observerUpdate(settingsCollection.updateOne(equal("_id", "settingsDocument"), set("moveCount", moveCount)))
      observerUpdate(settingsCollection.updateOne(equal("_id", "settingsDocument"), set("currentPlayer", currentPlayer)))
    }) match {
      case Success(_) =>
      case Failure(exception) => println(exception);
    }


  def recUpdateGrid(cells:JsArray, idx:Int):Unit = {
    if cells.value.length == idx then
      return
    val cell = cells.value(idx)
    val row = (cell \ "row").get.as[Int]
    val col = (cell \ "col").get.as[Int]
    val value = (cell \ "value").get.as[Int]
    observerUpdate(gridCollection.updateOne(equal("_id", idx), set("value", value)))
    observerUpdate(gridCollection.updateOne(equal("_id", idx), set("row", row)))
    observerUpdate(gridCollection.updateOne(equal("_id", idx), set("col", col)))
    recUpdateGrid(cells, idx + 1)
  }

  /** DELETE */
  override def delete:Unit = {
    Await.result(deleteFuture, Duration.Inf)
  }

  private def deleteFuture:Future[String] = {
    gridCollection.deleteMany(equal("_id", "gridDocument")).subscribe(
      (dr: DeleteResult) => println(s"Deleted gridDocument"),
      (e: Throwable) => println(s"Error while trying to delete gridDocument: $e")
    )
    recDelete(0)
    playerCollection.deleteMany(equal("_id", "player1Document")).subscribe(
      (dr: DeleteResult) => println(s"Deleted player1Document"),
      (e: Throwable) => println(s"Error while trying to delete player1Document: $e")
    )
    playerCollection.deleteMany(equal("_id", "player2Document")).subscribe(
      (dr: DeleteResult) => println(s"Deleted player2Document"),
      (e: Throwable) => println(s"Error while trying to delete player2Document: $e")
    )
    settingsCollection.deleteMany(equal("_id", "settingsDocument")).subscribe(
      (dr: DeleteResult) => println(s"Deleted settingsDocument"),
      (e: Throwable) => println(s"Error while trying to delete settingsDocument: $e")
    )
    Future {
      "Finished deleting!"
    }
  }

  private def recDelete(idx:Int): Unit =
    if 42 == idx then
      return;
    gridCollection.deleteMany(equal("_id", idx)).subscribe(
      (dr: DeleteResult) => println(s"Deleted $idx"),
      (e: Throwable) => println(s"Error while trying to delete $idx: $e")
    )
    recDelete(idx + 1)

  /** Observer */
  private def observerInsertion(insertObservable: SingleObservable[InsertOneResult]): Unit = {
    insertObservable.subscribe(new Observer[InsertOneResult] {
      override def onNext(result: InsertOneResult): Unit = ???//println(s"inserted: $result")

      override def onError(e: Throwable): Unit = ???//println(s"insert onError: $e")

      override def onComplete(): Unit = ???//println("completed insert")
    })
  }

  private def observerUpdate(insertObservable: SingleObservable[UpdateResult]): Unit = {
    insertObservable.subscribe(new Observer[UpdateResult] {
      override def onNext(result: UpdateResult): Unit = ???//println(s"updated: $result")

      override def onError(e: Throwable): Unit = ???//println(s"update onError: $e")

      override def onComplete(): Unit = ???//println("completed update")
    })
  }
