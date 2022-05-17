package de.htwg.se.ConnectFour.databaseComponent.MongoDB

import de.htwg.se.ConnectFour.databaseComponent.DAOInterface
import org.mongodb.scala.model.Filters.*
import org.mongodb.scala.result.{DeleteResult, InsertOneResult}
import play.api.libs.json.{JsArray, JsValue, Json}
import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Grid
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration


class DAOMongoDBImpl extends DAOInterface {

  val uri: String = "mongodb://mongo:27017/"
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("ConnectFour")
  val gridCollection: MongoCollection[Document] = db.getCollection("grid")
  val playerCollection: MongoCollection[Document] = db.getCollection("player")
  val settingsCollection: MongoCollection[Document] = db.getCollection("settings")

  /** CREATE */
  override def create =
    val gridDocument: Document = Document("_id" -> "gridDocument")
    val player1Document: Document = Document("_id" -> "playerDocument1", "playerNum" -> 1, "playerName" -> player1)
    val player2Document: Document = Document("_id" -> "playerDocument2", "playerNum" -> 2, "playerName" -> player2)
    val settingsDocument: Document = Document("_id" -> "settingsDocument", "moveCount" -> moveCount, "currentPlayer" -> currentPlayer)
    observerInsertion(gridCollection.insertOne(gridDocument))
    observerInsertion(playerCollection.insertOne(player1Document))
    observerInsertion(playerCollection.insertOne(player2Document))
    observerInsertion(settingsCollection.insertOne(settingsDocument))

  /** Load */
  override def load:String =
    val gridDocument: Document = Await.result(levelCollection.find(equal("_id", "gridDocument")).first().head(), Duration.Inf)
    val player1Document: Document = Await.result(levelCollection.find(equal("_id", "playerDocument1")).first().head(), Duration.Inf)
    val player2Document: Document = Await.result(levelCollection.find(equal("_id", "playerDocument2")).first().head(), Duration.Inf)
    val settingsDocument: Document = Await.result(levelCollection.find(equal("_id", "settingsDocument")).first().head(), Duration.Inf)
    //Player1?
    val player1 = m_player1 match
      case Some(a) => Cell(Some(Piece(Player(player1Document("playerName").asString().getValue, player1Document("playerNum").asInt32().getValue))))
      case None => Cell(Some(Piece(Player("Player_1", 1))))
    //Player2?
    val player2 = m_player2 match
      case Some(a) => Cell(Some(Piece(Player(player2Document("playerName").asString().getValue, player2Document("playerNum").asInt32().getValue))))
      case None => Cell(Some(Piece(Player("Player_2", 2))))

    var temp_grid = Grid(Vector.tabulate(6, 7) { (rowCount, col) => Cell(None) })
    for (x <- 0 to gridDocument("row").asInt32().getValue - 1) {
      for (y <- 0 to gridDocument("col").asInt32().getValue - 1) {
        val result = gridDocument("value").asInt32().getValue
        val r = result.toList.map(x => x._4 match
          case "1" => temp_grid = temp_grid.replaceCell(x._2, x._3, player1)
          case "2" => temp_grid = temp_grid.replaceCell(x._2, x._3, player2)
          case _ => temp_grid = temp_grid.replaceCell(x._2, x._3, Cell(None)))
      }
    temp_grid.toJsonString(1,player1,player1,player2)


      /** SAVE */
  override def save(input:String) =
    val gameJson: JsValue = Json.parse(input)
    val moveCount = (gameJson \ "player" \ "moveCount" \ "value").get.toString().toInt
    val currentPlayer = (gameJson \ "player" \ "currentPlayer" \ "name").get.toString().toString
    val player1 = (gameJson \ "player" \ "player1" \ "name").get.toString()
    val player2 = (gameJson \ "player" \ "player2" \ "name").get.toString()

    Await.result(deleteFuture, Duration.Inf)
    val gridDocument: Document = Document("_id" -> "gridDocument")
    recUpdateGrid(cells, 0)

    val player1Document: Document = Document("_id" -> "playerDocument", "playerNum" -> 1, "playerName" -> player1)
    val player2Document: Document = Document("_id" -> "playerDocument", "playerNum" -> 2, "playerName" -> player2)

    val settingsDocument: Document = Document("_id" -> "settingsDocument", "moveCount" -> moveCount, "currentPlayer" -> currentPlayer)


    Try({
      observerInsertion(gridCollection.updateOne(gridDocument))
      observerInsertion(playerCollection.updateOne(player1Document))
      observerInsertion(playerCollection.updateOne(player2Document))
      observerInsertion(settingsCollection.updateOne(settingsDocument))
    }) match {
      case Success(value) => true
      case Failure(exception) => println(exception); false
    }
    None


  def recUpdateGrid(cells:JsArray, idx:Int):Unit =
    if cells.value.length == idx then
      return
    val cell = cells.value(idx)
    val row = (cell \ "row").get.as[Int]
    val col = (cell \ "col").get.as[Int]
    val value = (cell \ "value").get.as[Int]

    ObserverInsertion(gridCollection.insertOne(Document("_id" -> idx - 1), "row" -> row, "col" -> col,
      "value" -> value))
    recUpdateGrid(cells, idx + 1)

  /** DELETE */
  override def delete =
    collection.deleteMany(equal("_id", "gridDocument")).subscribe(
      (dr: DeleteResult) => println(s"Deleted gridDocument"),
      (e: Throwable) => println(s"Error while trying to delete gridDocument: $e")
    )
    collection.deleteMany(equal("_id", "playerDocument")).subscribe(
      (dr: DeleteResult) => println(s"Deleted playerDocument"),
      (e: Throwable) => println(s"Error while trying to delete playerDocument: $e")
    )
    collection.deleteMany(equal("_id", "settingsDocument")).subscribe(
      (dr: DeleteResult) => println(s"Deleted settingsDocument"),
      (e: Throwable) => println(s"Error while trying to delete settingsDocument: $e")
    )

  private def deleteFuture:Future[String] =
    this.delete
    Future { "Finished deleting!" }



  private def observerInsertion(insertObservable: SingleObservable[InsertOneResult]): Unit = {
    insertObservable.subscribe(new Observer[InsertOneResult] {
      override def onNext(result: InsertOneResult): Unit = println(s"inserted: $result")

      override def onError(e: Throwable): Unit = println(s"onError: $e")

      override def onComplete(): Unit = println("completed")
    })
  }
}
