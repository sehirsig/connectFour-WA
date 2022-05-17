package de.htwg.se.ConnectFour.databaseComponent.MongoDB

import de.htwg.se.ConnectFour.databaseComponent.DAOInterface
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.result.{DeleteResult, InsertOneResult}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration


class DAOMangoDBImpl extends DAOInterface {

  val uri: String = "mongodb://mongo:27017/"
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("ConnectFour")
  val collection: MongoCollection[Document] = db.getCollection("connectfour")

  /** CREATE */
  override def create =
    None

  /** Load */
  override def load:String =
    ""

  /** SAVE */
  override def save(input:String) =
    Await.result(deleteFuture, Duration.Inf)
    None

  /** DELETE */
  override def delete =
    collection.deleteMany(equal("_id", "gameDocument")).subscribe(
      (dr: DeleteResult) => println(s"Deleted gameDocument"),
      (e: Throwable) => println(s"Error while trying to delete gameDocument: $e")
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
