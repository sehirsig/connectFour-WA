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
class ControllerImpl @Inject () (var grid:Grid, val playerBuilder:PlayerBuilder) extends Controller {
  val injector = Guice.createInjector(new GameModule)
  val fileIo = injector.getInstance(classOf[FileIO])

  var players: Vector[Player] = Vector.empty
  var moveCount = 0
  var currentPlayer:Player = _
  val maxPlayers = 2
  override val undoManager: UndoManager = new UndoManager

  override def createGrid(): Unit = {
    reset()
    notifyObservers
  }

  override def addPlayer(name:String):Unit = {
    if (players.size == 0) {
      val player = playerBuilder.createPlayer(name,1)
      players = players.appended(player)
      println("Player 1 is called: " + name)
    }
    else {
      val player = playerBuilder.createPlayer(name,2)
      players = players.appended(player)
      println("Player 2 is called: " + name)
    }
  }

  override def whoseTurnIsIt(): Unit = {
    currentPlayer = if (moveCount % 2 == 0) players(0) else players(1)
    notifyObservers
  }

  override def checkWin():Boolean = {
    grid.checkWin(currentPlayer)
  }


  override def drop(col:String): Unit = {
    whoseTurnIsIt()
    var validCol = 0
    if (col.toInt <= 6)
      validCol = col.toInt
    undoManager.doStep(new SetCommandImpl(validCol, Piece(currentPlayer),this));
    moveCount += 1
    notifyObservers
  }

  override def undoDrop(): Unit = {
    undoManager.undoStep
    moveCount -= 1
    notifyObservers
  }

  override def redoDrop(): Unit = {
    undoManager.redoStep
    moveCount += 1
    notifyObservers
  }

  override def saveGame(): Unit = {
    fileIo.save(this)
    notifyObservers
  }

  override def loadGame(): Unit = {
    fileIo.load(this)
    notifyObservers
  }

  override def reset(): Unit = {
    grid = grid.reset()
    notifyObservers
  }

  override def gridToString(): String = this.grid.toString
  override def getGrid(): Grid = this.grid
  override def getPlayers(): Vector[Player] = this.players
  override def getCurrentPlayer(): Player = this.currentPlayer
  override def getMoveCount: Int = this.moveCount
  override def setGrid(grid: Grid): Unit = this.grid = grid;notifyObservers
  override def setCurrentPlayer(currentPlayer: Player): Unit = this.currentPlayer = currentPlayer;notifyObservers
  override def setMoveCount(moveCount:Int): Unit = this.moveCount = moveCount;notifyObservers
}

