package de.htwg.se.ConnectFour.controller.impl

import com.google.inject.{Guice, Inject, Key}
import de.htwg.se.ConnectFour.GameModule
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.model.fileio.FileIO
import de.htwg.se.ConnectFour.model.grid.{Grid, Piece}
import de.htwg.se.ConnectFour.model.player.{Player, PlayerBuilder}
import de.htwg.se.ConnectFour.util.UndoManager

/**
 *  Controller implementation
 */
class ControllerImpl @Inject () (var grid:Grid, val playerBuilder:PlayerBuilder) extends Controller:
  val injector = Guice.createInjector(new GameModule)
  val fileIo = injector.getInstance(classOf[FileIO])

  var players: Vector[Player] = Vector.empty
  var moveCount = 0
  var currentPlayer:Player = _
  val maxPlayers = 2
  override val undoManager: UndoManager = new UndoManager

  override def createGrid() =
    reset()
    notifyObservers

  override def addPlayer(name:String) =
    if players.size == 0 then
      val player = playerBuilder.createPlayer(name,1)
      players = players.appended(player)
      println("Player 1 is called: " + name)
    else
      val player = playerBuilder.createPlayer(name,2)
      players = players.appended(player)
      println("Player 2 is called: " + name)
    end if

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
    undoManager.doStep(new SetCommandImpl(validCol, Piece(currentPlayer),this));
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
    fileIo.save(this)
    notifyObservers

  override def loadGame() =
    fileIo.load(this)
    notifyObservers

  override def reset() =
    grid = grid.reset()
    notifyObservers

  override def gridToString(): String = this.grid.toString
  override def getGrid(): Grid = this.grid
  override def getPlayers(): Vector[Player] = this.players
  override def getCurrentPlayer(): Player = this.currentPlayer
  override def getMoveCount: Int = this.moveCount
  override def setGrid(grid: Grid) = this.grid = grid;notifyObservers
  override def setCurrentPlayer(currentPlayer: Player) = this.currentPlayer = currentPlayer;notifyObservers
  override def setMoveCount(moveCount:Int) = this.moveCount = moveCount;notifyObservers