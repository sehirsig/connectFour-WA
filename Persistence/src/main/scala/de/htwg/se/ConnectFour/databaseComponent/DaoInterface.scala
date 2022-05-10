package de.htwg.se.ConnectFour.databaseComponent

import de.htwg.se.ConnectFour.databaseComponent.Slick.tables.GridTable
import de.htwg.se.ConnectFour.model.gridComponent.GridInterface
import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Grid
import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player

import scala.concurrent.Future

trait DaoInterface:

  def readPlayer(playerId: Int): Option[(Int, Int, Option[String], String)]

  def updatePlayer(id: Int, name: String): String

  def deletePlayer(num:Int): Future[Any]

  def createDB(): Unit

  def createPlayer(player: Player): Int

  def readAllPlayers():List[(Int, Int, Option[String], String)]

  def deleteAllPlayers(): Unit

  def createGrid(): Unit

  def readPiece(row: Int, col: Int): Option[(Int, Int, Int, String)]

  def updatePiece(row: Int, col: Int, value: String): String

  def resetGrid(): Unit

  def updateGrid(grid:String): Unit

  def deleteGrid(): Unit

  def readGrid(): GridInterface

  def loadGrid():String

  def loadGrid_UI():String