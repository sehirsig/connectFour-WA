package de.htwg.se.ConnectFour.databaseComponent

import de.htwg.se.ConnectFour.databaseComponent.Slick.tables.GridTable
import de.htwg.se.ConnectFour.model.playerComponent.Player
import de.htwg.se.ConnectFour.model.gridComponent.Grid

import scala.concurrent.Future

trait DaoInterface:

  def readPlayer(playerId: Int): Option[(Int, Int, Option[String], String)]

  def updatePlayer(id: Int, name: String): String

  def deletePlayer(num:Int): Future[Any]

  def createDB(): Unit

  def createPlayer(player: Player): Int

  def readAllPlayers():List[(Int, Int, Option[String], String)]

  def deleteAllPlayers(): Unit

  def createGrid(): Grid

  def resetGrid(): Grid

  def updateGrid(): Unit

  def deleteGrid(): Unit