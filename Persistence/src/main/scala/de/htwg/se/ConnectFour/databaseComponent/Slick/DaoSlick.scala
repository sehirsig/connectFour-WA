package de.htwg.se.ConnectFour.databaseComponent.Slick

import com.google.inject.Inject
import de.htwg.se.ConnectFour.databaseComponent.DaoInterface
import de.htwg.se.ConnectFour.databaseComponent.Slick.tables.{GridTable, PlayerTable}
import de.htwg.se.ConnectFour.model.gridComponent.Cell
import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Grid
import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player
import play.api.libs.json.Json
//import slick.driver.PostgresDriver.api.*
import slick.jdbc.JdbcBackend.Database
import slick.lifted.TableQuery
import slick.jdbc.PostgresProfile.api.*

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, DurationInt}
import scala.concurrent.{Await, Future}
import scala.io.StdIn
import scala.util.{Failure, Success, Try}

class DaoSlick @Inject () extends DaoInterface:

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
  val gridTable = TableQuery[GridTable]

  //Create Database
  //Await.result(database.run(playerTable.schema.createIfNotExists), Duration.Inf)

  override def createDB(): Unit =
    val playerDB = Future(Await.result(database.run(playerTable.schema.createIfNotExists), Duration.Inf))
    val gridDB = Future(Await.result(database.run(gridTable.schema.createIfNotExists), Duration.Inf))
    playerDB.onComplete {
      case Success(_) => print("Connection to DB & Creation of playerTable successful!")
      case Failure(e) => print("Error: " + e)
    }
    gridDB.onComplete {
      case Success(_) => print("Connection to DB & Creation of gridTable successful!")
      case Failure(e) => print("Error: " + e)
    }

  override def readPlayer(playerId: Int): Option[(Int, Int, Option[String], String)] =
    val actionQuery = sql"""SELECT * FROM "PLAYER" WHERE "number" = $playerId""".as[(Int, Int, Option[String], String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result match {
      case Seq(a) => Some((a._1, a._2, a._3, a._4))
      case _ => None
    }

  override def readPiece(row: Int, col: Int): Option[(Int, Int, Int, String)] =
    val actionQuery = sql"""SELECT * FROM "GRID" WHERE "row" = $row AND "col" = $col""".as[(Int, Int, Int, String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result match {
      case Seq(a) => Some((a._1, a._2, a._3, a._4))
      case _ => None
    }

  override def updatePiece(row: Int, col: Int, value: String):String  =
    if readPiece(row,col) == None then
      return "Grid Piece non existent."
    val actionQuery =
      sql"""UPDATE "GRID" SET "value" = $value WHERE "row" = $row AND "col" = $col""".as[(Int, Int, String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result.toString()

  override def updatePlayer(id: Int, name: String):String   =
    if readPlayer(id) == None then
      return "Player non existent."
    val actionQuery =
      sql"""UPDATE "PLAYER" SET "number" = id, "name" = $name WHERE "number" = $id""".as[(Int, Int, Option[String], String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result.toString()

  override def deletePlayer(num:Int): Future[Any] =
    val action = playerTable.filter(_.id === num ).delete
    Future(Await.result(database.run(action), atMost = 10.second))

  override def createPlayer(player: Player): Int =
    if readAllPlayers().length > 1 then
      return -1
    Try({
      database.run(playerTable += (1, player.playerNumber, player.color, player.playerName))
      player.playerNumber
    }) match {
      case Success(_) =>
        println("Geklappt");player.playerNumber
      case Failure(exception) => println(exception); -1
    }

  override def createGrid(): Unit =
    Try({
      var counter = 1
      (0 to 7 - 1).flatMap(col =>
        (0 to 6 - 1).reverse.map(row => {
          database.run(gridTable += (counter,row, col, "None"))
          counter+1
        }))
    }) match {
      case Success(_) =>
        println("42 Grid Felder wurden erstellt");
      case Failure(exception) => println(exception); -1
    }

  override def readAllPlayers(): List[(Int, Int, Option[String], String)] =
    val actionQuery = sql"""SELECT * FROM "PLAYER"""".as[(Int, Int, Option[String], String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result.toList

  override def deleteAllPlayers() =
    val action = playerTable.delete
    Future(Await.result(database.run(action), atMost = 10.second))
    val deleteQuery = sql"""ALTER SEQUENCE player_id_seq RESTART WITH 1""".as[(Int, Int, Option[String], String)]
    Future(Await.result(database.run(deleteQuery), atMost = 10.second))


