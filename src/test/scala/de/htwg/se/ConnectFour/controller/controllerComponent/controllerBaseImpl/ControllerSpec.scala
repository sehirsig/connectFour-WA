package de.htwg.se.ConnectFour.controller.controllerComponent.controllerBaseImpl

import com.google.inject.Guice
import de.htwg.se.ConnectFour.controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.ConnectFour.model.gridComponent.GridInterface
import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Grid
import de.htwg.se.ConnectFour.model.playerComponent.PlayerBuilderInterface
import de.htwg.se.ConnectFour.model.playerComponent.playerBuilderBaseImpl.PlayerBuilder
import de.htwg.se.ConnectFour.util.Observer
//import model.fileIOComponent.FileIOInterface
import de.htwg.se.ConnectFour.ConnectFourModule
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.util.Failure

/**
 * Controller tests.
 */
class ControllerSpec extends AnyWordSpec with Matchers:
  val injector = Guice.createInjector(ConnectFourModule())
  val grid = injector.getInstance(classOf[GridInterface])
  val playerbuilder = injector.getInstance(classOf[PlayerBuilderInterface])
  val controller = new Controller(grid, new PlayerBuilder())
  controller.moveCount = 0
  controller.buildPlayer("Player1", 1)
  controller.buildPlayer("Player2", 2)
  controller.currentPlayer = controller.players(0)

  "A Controller" when {
    "observed by an Observer" should {
      val observer = new Observer {
        var updated: Boolean = false

        def isUpdated: Boolean = updated

        override def update: Boolean = {
          updated = true; updated
        }

        override def toString: String = updated.toString
      }
      controller.add(observer)
      "notify its Observer after grid creation" in {
        controller.createGrid()
        observer.toString should be("true")
        controller.grid should be(grid)
      }
      "notify its Observer which player has the turn" in {
        controller.whoseTurnIsIt()
        observer.toString should be("true")
        controller.currentPlayer should be(controller.players(0))
      }
      "notify its Observer after resetting the grid" in {
        controller.reset()
        observer.toString should be("true")
        controller.grid should be(grid)
      }
      "notify its Observer when a do/undo/redo step is done" should {
        "do" in {
          controller.drop("0")
          controller.gridToString()
          controller.grid.cell(0, 0).isSet should be(true)
        }
        "undo" in {
          controller.undoDrop()
          controller.gridToString()
          controller.grid.cell(0, 0).isSet should be(false)
        }
        "redo" in {
          controller.redoDrop()
          controller.gridToString()
          controller.grid.cell(0, 0).isSet should be(true)
        }
        "drop 0 when an illegal number has been selected to drop" in {
          controller.drop("0")
          controller.gridToString()
          controller.grid.cell(1, 0).isSet should be(true)
        }
      }
      "notify its Observer that the game has been saved" in {
        controller.saveGame()
      }
      "notify its Observer that the game has been loaded" in {
        controller.loadGame()
      }
    }
  }
  "use its get methods deliver specific values" should {
    "for accessing the grid" in {
      controller.getGrid() should be (controller.grid)
    }
    "for accessing the players" in {
      controller.getPlayers() should be (controller.players)
    }
    "for accessing the current player" in {
      controller.getCurrentPlayer() should be (controller.currentPlayer)
    }
    "for accessing the move count" in {
      controller.getMoveCount should be (controller.moveCount)
    }
  }
  "use its set methods they should overwrite existing variables" should {
    "for setting the grid" in {
      controller.setGrid(controller.getGrid())
    }
    "for setting the current player" in {
      controller.setCurrentPlayer(controller.players(0))
      controller.currentPlayer should be (controller.players(0))
    }
    "for setting the move count" in {
      controller.setMoveCount(203)
      controller.moveCount should be (203)
    }
  }
  "when using its help methods" should {
    "have a correct value when checking for win" in {
      controller.checkWin() should be (false)
    }
    "change the currentplayer when using whoseTurnIsIt() method" in {
      controller.moveCount += 1
      controller.currentPlayer should be (controller.players(0))
      controller.moveCount += 1
      controller.whoseTurnIsIt()
      controller.currentPlayer should be (controller.players(1))
    }
  }
