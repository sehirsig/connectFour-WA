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


class DAOMongoDBSimpleImpl @Inject () extends DAOInterface:

  /** Init */
  val database_pw = sys.env.getOrElse("MONGO_INITDB_ROOT_PASSWORD", "mongo").toString
  val database_username = sys.env.getOrElse("MONGO_INITDB_ROOT_USERNAME", "root").toString

  val uri: String = s"mongodb://$database_username:$database_pw@localhost:27017/?authSource=admin"
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("ConnectFour")
  val gameCollection: MongoCollection[Document] = db.getCollection("game")

  /** CREATE */
  override def create =
    val gameDocument: Document = Document("_id" -> "gameDocument", "game" -> "")
    observerInsertion(gameCollection.insertOne(gameDocument))

  /** READ */
  override def read:String =
    val gameDocument: Document = Await.result(gameCollection.find(equal("_id", "gameDocument")).first().head(), Duration.Inf)
    gameDocument("game").asString().getValue.toString

  /** UPDATE */
  override def update(input:String) =
    observerUpdate(gameCollection.updateOne(equal("_id","gameDocument"), set("game", input)))

  /** DELETE */
  override def delete:Unit = {
    Await.result(deleteFuture, Duration.Inf)
  }

  private def deleteFuture:Future[String] = {
    gameCollection.deleteMany(equal("_id", "gameDocument")).subscribe(
      (dr: DeleteResult) => println(s"Deleted gameDocument"),
      (e: Throwable) => println(s"Error while trying to delete gameDocument: $e")
    )
    Future {
      "Finished deleting!"
    }
  }


  /** Observer */
  private def observerInsertion(insertObservable: SingleObservable[InsertOneResult]): Unit = {
    insertObservable.subscribe(new Observer[InsertOneResult] {
      override def onNext(result: InsertOneResult): Unit = println(s"inserted: $result")

      override def onError(e: Throwable): Unit = println(s"insert onError: $e")

      override def onComplete(): Unit = println("completed insert")
    })
  }

  private def observerUpdate(insertObservable: SingleObservable[UpdateResult]): Unit = {
    insertObservable.subscribe(new Observer[UpdateResult] {
      override def onNext(result: UpdateResult): Unit = println(s"updated: $result")

      override def onError(e: Throwable): Unit = println(s"update onError: $e")

      override def onComplete(): Unit = println("completed update")
    })
  }
