package de.htwg.se.ConnectFour.databaseComponent.Slick

import de.htwg.se.ConnectFour.databaseComponent.DAOInterface
import com.google.inject.Inject
import de.htwg.se.ConnectFour.databaseComponent.DBInterface
import de.htwg.se.ConnectFour.databaseComponent.Slick.tables.{GridTable, PlayerTable, SettingsTable}
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

class DAOSlickGridPlayerImpl @Inject () extends DAOInterface {
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
  val settingsTable = TableQuery[SettingsTable]

  /** CREATE */
  override def create =
    val running = Future(Await.result(database.run(DBIO.seq(
      playerTable.schema.createIfNotExists,
      gridTable.schema.createIfNotExists,
      settingsTable.schema.createIfNotExists
    )), Duration.Inf))
    running.onComplete{
      case Success(_) => println("Connection to DB & Creation of Tables successful!")
      case Failure(e) => println("Error: " + e)
    }
    createGrid()
    createPlayers()
    createSet()

  def createSet() =
    Await.result(database.run(settingsTable += (1,"Player 1", 0)), atMost = 10.second)

  def createPlayers()=
    Await.result(database.run(playerTable += (1, 1, Some("red"), "Player 1")), atMost = 10.second)
    Await.result(database.run(playerTable += (2, 2, Some("yellow"), "Player 2")), atMost = 10.second)

  def createGrid():Unit =
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

  def resetGrid() =
    val new_value = "None"
    val actionQuery = sql"""UPDATE "GRID" SET "value" = $new_value WHERE "value" != $new_value""".as[Int]
    Await.result(database.run(actionQuery), atMost = 10.second)

  /** UPDATE */
  override def update(input: String): Unit =
    this.create
    val gameJson: JsValue = Json.parse(input)
    val grid = (gameJson \ "grid")
    val cells = (grid \ "cells").as[JsArray]
    updatePlayers(input)
    recUpdateGrid(cells, 0)

  def updatePlayers(input: String) =
    val gameJson: JsValue = Json.parse(input)
    val moveCount = (gameJson \ "player" \ "moveCount" \ "value").get.toString().toInt
    val currentPlayer = (gameJson \ "player" \ "currentPlayer" \ "name").get.toString().toString
    val player1 = (gameJson \ "player" \ "player1" \ "name").get.toString()
    val player2 = (gameJson \ "player" \ "player2" \ "name").get.toString()

    val settingsQuery =
      sql"""UPDATE "SETTINGS" SET "currplayer" = $currentPlayer, "movecount" = $moveCount WHERE "id" = 1""".as[(String,Int)]
    Await.result(database.run(settingsQuery), atMost = 10.second)

    val actionQuery =
      sql"""UPDATE "PLAYER" SET "number" = 1, "name" = $player1 WHERE "id" = 1""".as[(Int, Int, Option[String], String)]
    Await.result(database.run(actionQuery), atMost = 10.second)
    val actionQuery2 =
      sql"""UPDATE "PLAYER" SET "number" = 2, "name" = $player2 WHERE "number" = 2""".as[(Int, Int, Option[String], String)]
    Await.result(database.run(actionQuery2), atMost = 10.second)

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

  /** READ */
  override def read: String =
    val player1Query = sql"""SELECT * FROM "PLAYER" WHERE "id" = 1""".as[(Int, Int, Option[String], String)]
    val result1 = Await.result(database.run(player1Query), atMost = 10.second)
    val player1 = result1 match {
      case Seq(a) => a._4
      case _ => "Player 1"
    }
    val player2Query = sql"""SELECT * FROM "PLAYER" WHERE "id" = 2""".as[(Int, Int, Option[String], String)]
    val result2 = Await.result(database.run(player2Query), atMost = 10.second)
    val player2 = result2 match {
      case Seq(a) => a._4
      case _ => "Player 2"
    }

    val settingsQuery = sql"""SELECT * FROM "SETTINGS" WHERE "id" = 1 """.as[(Int, String, Int)]
    val settingsResult = Await.result(database.run(settingsQuery), atMost = 10.second)
    val settings = settingsResult match {
      case Seq(a) => print("Good");(a._2, a._3)
      case _ => print("Fail");("Player 1", 0)
    }

    val grid = readGrid()
    grid.toJsonString(settings._2, settings._1, player1, player2)

  def readGrid(): GridInterface =
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

  def readPlayer(playerId: Int): Option[(Int, Int, Option[String], String)] =
    val actionQuery = sql"""SELECT * FROM "PLAYER" WHERE "number" = $playerId""".as[(Int, Int, Option[String], String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result match
      case Seq(a) => Some((a._1, a._2, a._3, a._4))
      case _ => None


  /** DELETE */
  override def delete =
    val deletePlayerTable = playerTable.delete
    Await.result(database.run(deletePlayerTable), atMost = 10.second)
    val deleteQuery = sql"""ALTER SEQUENCE "PLAYER_id_seq" RESTART WITH 1""".as[Int]
    Await.result(database.run(deleteQuery), atMost = 10.second)

    val deleteGridTable = gridTable.delete
    Await.result(database.run(deleteGridTable), atMost = 10.second)
    val deleteQuery2 = sql"""ALTER SEQUENCE "GRID_id_seq" RESTART WITH 1""".as[Int]
    Await.result(database.run(deleteQuery2), atMost = 10.second)

    val deleteSettingsTable = settingsTable.delete
    Await.result(database.run(deleteSettingsTable), atMost = 10.second)
    val deleteQuery3 = sql"""ALTER SEQUENCE "SETTINGS_id_seq" RESTART WITH 1""".as[Int]
    Await.result(database.run(deleteQuery3), atMost = 10.second)

}
