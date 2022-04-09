package de.htwg.se.ConnectFour.controller.controllerComponent

import model.gridComponent.GridInterface
import model.playerComponent.{PlayerBuilderInterface, PlayerInterface}
import de.htwg.se.ConnectFour.util.{Observable, UndoManager}

/**
 * Controller Trait
 */
trait ControllerInterface extends Observable :
  var grid: GridInterface
  val playerBuilder: PlayerBuilderInterface
  var players: Vector[PlayerInterface]
  var moveCount: Int
  var currentPlayer: PlayerInterface
  val maxPlayers: Int
  val undoManager: UndoManager

  def createGrid(): Unit

  def addPlayer(name: String): Unit

  def whoseTurnIsIt(): Unit

  def checkWin(): Boolean

  def drop(input: String): Unit

  def undoDrop(): Unit

  def redoDrop(): Unit

  def saveGame(): Unit

  def loadGame(): Unit

  def reset(): Unit

  def gridToString(): String

  def getGrid(): GridInterface

  def getPlayers(): Vector[PlayerInterface]

  def getCurrentPlayer(): PlayerInterface

  def getMoveCount: Int

  def setGrid(grid: GridInterface): Unit

  def setCurrentPlayer(currentPlayer: PlayerInterface): Unit

  def setMoveCount(moveCount: Int): Unit
