package de.htwg.se.ConnectFour.databaseComponent.Slick

import de.htwg.se.ConnectFour.databaseComponent.DAOInterface

import com.google.inject.Inject
import de.htwg.se.ConnectFour.databaseComponent.DBInterface
import de.htwg.se.ConnectFour.databaseComponent.Slick.tables.{GridTable, PlayerTable}
import de.htwg.se.ConnectFour.model.gridComponent.{Cell, GridInterface, Piece}
import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Grid
import de.htwg.se.ConnectFour.model.playerComponent.PlayerInterface
import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player
import play.api.libs.json.{JsArray, JsValue, Json}
import slick.jdbc.JdbcBackend.Database
import slick.lifted.TableQuery
import slick.jdbc.PostgresProfile.api.*

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, DurationInt}
import scala.concurrent.{Await, Future}
import scala.io.StdIn
import scala.util.{Failure, Success, Try}

class DAOSlickPlayerImpl @Inject () extends DAOInterface {
  val connectIP = sys.env.getOrElse("POSTGRES_IP", "localhost").toString
  val connectPort = sys.env.getOrElse("POSTGRES_PORT", 5432).toString.toInt
  val database_user = sys.env.getOrElse("POSTGRES_USER", "postgres").toString
  val database_pw = sys.env.getOrElse("POSTGRES_PASSWORD", "postgres").toString
  val database_name = sys.env.getOrElse("POSTGRES_DB", "postgres").toString

  val database =
    Database.forURL(
      url = "jdbc:postgresql://" + connectIP + ":" + connectPort + "/" + database_name + "?serverTimezone=UTC",
      user = database_user,
      password = database_pw,
      driver = "org.postgresql.Driver")

  val playerTable = TableQuery[PlayerTable]

  override def create =
    val playerDB = Future(Await.result(database.run(playerTable.schema.createIfNotExists), Duration.Inf))
    playerDB.onComplete {
      case Success(_) => print("Connection to DB & Creation of playerTable successful!")
      case Failure(e) => print("Error: " + e)
    }

  override def update(input: String): Unit =
    val gameJson: JsValue = Json.parse(input)
    val moveCount = (gameJson \ "player" \ "moveCount" \ "value").get.toString().toInt
    val currentPlayer = (gameJson \ "player" \ "currentPlayer").get.toString()
    val player1 = (gameJson \ "player" \ "player1" \ "name").get.toString()
    val player2 = (gameJson \ "player" \ "player2" \ "name").get.toString()

    if readPlayer(1) == None || readPlayer(2) == None then
      return "Player non existent."
    val actionQuery =
      sql"""UPDATE "PLAYER" SET "number" = 1, "name" = $player1 WHERE "id" = 1""".as[(Int, Int, Option[String], String)]
    Await.result(database.run(actionQuery), atMost = 10.second)
    val actionQuery2 =
      sql"""UPDATE "PLAYER" SET "number" = 2, "name" = $player2 WHERE "number" = 2""".as[(Int, Int, Option[String], String)]
    Await.result(database.run(actionQuery2), atMost = 10.second)

  override def read: Future[String] =
    val actionQuery = sql"""SELECT * FROM "PLAYER"""".as[(Int, Int, Option[String], String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    Future(result.toList.toString())

  override def delete =
    val action = playerTable.delete
    Await.result(database.run(action), atMost = 10.second)
    val deleteQuery = sql"""ALTER SEQUENCE "PLAYER_id_seq" RESTART WITH 1""".as[Int]
    Await.result(database.run(deleteQuery), atMost = 10.second)

  def readPlayer(playerId: Int): Option[(Int, Int, Option[String], String)] =
    val actionQuery = sql"""SELECT * FROM "PLAYER" WHERE "number" = $playerId""".as[(Int, Int, Option[String], String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result match
      case Seq(a) => Some((a._1, a._2, a._3, a._4))
      case _ => None
}
