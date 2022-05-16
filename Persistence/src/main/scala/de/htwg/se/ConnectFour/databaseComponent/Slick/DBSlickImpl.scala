package de.htwg.se.ConnectFour.databaseComponent.Slick

import com.google.inject.Inject
import de.htwg.se.ConnectFour.databaseComponent.DBInterface
import de.htwg.se.ConnectFour.databaseComponent.Slick.tables.{GridTable, PlayerTable}
import de.htwg.se.ConnectFour.model.gridComponent.{Cell, GridInterface, Piece}
import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Grid
import de.htwg.se.ConnectFour.model.playerComponent.PlayerInterface
import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player
import play.api.libs.json.{JsArray, JsValue, Json}
//import slick.driver.PostgresDriver.api.*
import slick.jdbc.JdbcBackend.Database
import slick.lifted.TableQuery
import slick.jdbc.PostgresProfile.api.*

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, DurationInt}
import scala.concurrent.{Await, Future}
import scala.io.StdIn
import scala.util.{Failure, Success, Try}

class DBSlickImpl @Inject () extends DBInterface:

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
    val actionQuery = sql"""SELECT * FROM "GRID" WHERE "row" = $row AND "column" = $col""".as[(Int, Int, Int, String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result match {
      case Seq(a) => Some((a._1, a._2, a._3, a._4))
      case _ => None
    }

  override def updatePiece(row: Int, col: Int, value: String):String  =
    if readPiece(row,col) == None then
      return "Grid Piece non existent."
    val actionQuery =
      sql"""UPDATE "GRID" SET "value" = $value WHERE "row" = $row AND "column" = $col""".as[(Int, Int, String)]
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
      database.run(playerTable += (0, player.playerNumber, player.color, player.playerName))
      player.playerNumber
    }) match {
      case Success(_) =>
        println("Geklappt");player.playerNumber
      case Failure(exception) => println(exception); -1
    }

  override def createGrid() =
    if isGridCreated() then
      resetGrid()
      return println("Grid already created! Resetting Grid.")

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
      case Failure(exception) => println(exception);
    }

  def isGridCreated():Boolean =
    val actionQuery = sql"""SELECT * FROM "GRID"""".as[(Int, Int, Int, String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    !result.toList.isEmpty

  override def readAllPlayers(): List[(Int, Int, Option[String], String)] =
    val actionQuery = sql"""SELECT * FROM "PLAYER"""".as[(Int, Int, Option[String], String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result.toList

  override def deleteAllPlayers() =
    val action = playerTable.delete
    Await.result(database.run(action), atMost = 10.second)
    val deleteQuery = sql"""ALTER SEQUENCE "PLAYER_id_seq" RESTART WITH 1""".as[Int]
    Await.result(database.run(deleteQuery), atMost = 10.second)

  override def deleteGrid() =
    val action = gridTable.delete
    Await.result(database.run(action), atMost = 10.second)
    val deleteQuery = sql"""ALTER SEQUENCE "GRID_id_seq" RESTART WITH 1""".as[Int]
    Await.result(database.run(deleteQuery), atMost = 10.second)

  override def resetGrid() =
    val new_value = "None"
    val actionQuery = sql"""UPDATE "GRID" SET "value" = $new_value WHERE "value" != $new_value""".as[Int]
    Await.result(database.run(actionQuery), atMost = 10.second)

  override def readGrid(): GridInterface =
    val m_player1 = readPlayer(1)
    val player1 = m_player1 match
      case Some(a) => Cell(Some(Piece(Player(a._4, a._2))))
      case None => Cell(Some(Piece(Player("Player_1", 1))))
    val m_player2 = readPlayer(2)
    val player2 = m_player2 match
      case Some(a) => Cell(Some(Piece(Player(a._4, a._2))))
      case None => Cell(Some(Piece(Player("Player_2", 2))))
    val actionQuery = sql"""SELECT * FROM "GRID"""".as[(Int, Int, Int, String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    var temp_grid = Grid(Vector.tabulate(6, 7) { (rowCount, col) => Cell(None) })
    val r = result.toList.map(x => x._4 match
      case "1" => temp_grid = temp_grid.replaceCell(x._2, x._3, player1)
      case "2" => temp_grid = temp_grid.replaceCell(x._2, x._3, player2)
      case _ => temp_grid = temp_grid.replaceCell(x._2, x._3, Cell(None)))
    return temp_grid

  override def loadGrid():String =
    val m_player1 = readPlayer(1)
    val player1 = m_player1 match
      case Some(a) => a._4
      case None => "Player 1"
    val m_player2 = readPlayer(2)
    val player2 = m_player2 match
      case Some(a) => a._4
      case None => "Player 2"
    this.readGrid().toJsonString(1, player1, player1, player2)

  override def loadGrid_UI():String =
    this.readGrid().toPlainString


  override def updateGrid(input: String) =
    createGrid()
    val gameJson: JsValue = Json.parse(input)
    val grid = (gameJson \ "grid")
    val cells = (grid \ "cells").as[JsArray]
    recUpdateGrid(cells, 0)


  def recUpdateGrid(cells:JsArray, idx:Int):Unit =
    if cells.value.length == idx then
      return
    val cell = cells.value(idx)
    val row = (cell \ "row").get.as[Int]
    val col = (cell \ "col").get.as[Int]
    val value = (cell \ "value").get.as[Int]

    val actionQuery =
      sql"""UPDATE "GRID" SET "value" = $value WHERE "row" = $row AND "column" = $col""".as[(Int, Int, String)]
    Await.result(database.run(actionQuery), atMost = 10.second)
    recUpdateGrid(cells, idx + 1)
