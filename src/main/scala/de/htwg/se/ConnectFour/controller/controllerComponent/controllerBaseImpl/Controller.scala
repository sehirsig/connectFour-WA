package de.htwg.se.ConnectFour.controller.controllerComponent.controllerBaseImpl

import com.google.inject.{Guice, Inject, Key}
import de.htwg.se.ConnectFour.ConnectFourModule
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import tools.util.UndoManager
import model.gridComponent.{GridInterface, Piece}
import model.playerComponent.{PlayerBuilderInterface, PlayerInterface}
import fileIOComponent.FileIOInterface

/**
 *  Controller implementation
 */
class Controller @Inject ()(var grid:GridInterface, val playerBuilder:PlayerBuilderInterface) extends ControllerInterface:
  val injector = Guice.createInjector(ConnectFourModule())
  val fileIo = injector.getInstance(classOf[FileIOInterface])

  var players: Vector[PlayerInterface] = Vector.empty
  var moveCount = 0
  var currentPlayer:PlayerInterface = _
  val maxPlayers = 2
  override val undoManager: UndoManager = new UndoManager

  override def createGrid() =
    reset()
    notifyObservers

  override def addPlayer(name:String) = if players.size == 0 then buildPlayer(name,1) else buildPlayer(name,2)

  def buildPlayer(name:String, number:Int) =
    val player = playerBuilder.createPlayer(name,number)
    players = players.appended(player)

  override def whoseTurnIsIt() =
    currentPlayer = if moveCount % 2 == 0 then players(0) else players(1)
    notifyObservers

  override def checkWin():Boolean =
    grid.checkWin(currentPlayer)

  override def drop(col:String) =
    whoseTurnIsIt()
    var validCol = 0
    if col.toInt <= 6 then
      validCol = col.toInt
    undoManager.doStep(SetCommand.SetCommand(validCol, Piece(currentPlayer),this));
    moveCount += 1
    notifyObservers

  override def undoDrop() =
    undoManager.undoStep
    moveCount -= 1
    notifyObservers

  override def redoDrop() =
    undoManager.redoStep
    moveCount += 1
    notifyObservers

  override def saveGame() =
    fileIo.save(this.grid)
    notifyObservers

  override def loadGame() =
    this.grid = fileIo.load(this.players(0), this.players(1), this.grid)
    notifyObservers

  override def reset() =
    grid = grid.reset()
    notifyObservers

  override def gridToString(): String = this.grid.toString
  override def getGrid(): GridInterface = this.grid
  override def getPlayers(): Vector[PlayerInterface] = this.players
  override def getCurrentPlayer(): PlayerInterface = this.currentPlayer
  override def getMoveCount: Int = this.moveCount
  override def setGrid(grid: GridInterface) = this.grid = grid;notifyObservers
  override def setCurrentPlayer(currentPlayer: PlayerInterface) = this.currentPlayer = currentPlayer;notifyObservers
  override def setMoveCount(moveCount:Int) = this.moveCount = moveCount;notifyObservers
