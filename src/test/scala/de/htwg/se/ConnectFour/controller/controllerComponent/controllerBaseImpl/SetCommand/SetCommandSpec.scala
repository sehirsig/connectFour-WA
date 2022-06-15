package de.htwg.se.ConnectFour.controller.controllerComponent.controllerBaseImpl.SetCommand

import de.htwg.se.ConnectFour.controller.controllerComponent.controllerBaseImpl.{Controller, SetCommand}
import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Grid
import de.htwg.se.ConnectFour.model.gridComponent.{Cell, GridInterface, Piece}
import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.ConnectFour.model.playerComponent.playerBuilderBaseImpl.PlayerBuilder
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * SetCommand tests.
 */
class SetCommandSpec extends AnyWordSpec with Matchers :
  val grid = Grid(Vector.tabulate(6, 7) { (rowCount, col) => Cell(None) })
  val playerbuilder = PlayerBuilder
  val controller = new Controller(grid, new PlayerBuilder())
  controller.moveCount = 0
  controller.buildPlayer("Player1", 1)
  controller.buildPlayer("Player2", 2)
  controller.currentPlayer = controller.players(0)

  "A Command" should {
    "have a do step" in {
      val command = SetCommand.SetCommand(1, Piece(controller.currentPlayer), controller)
      command.memento should be(controller.grid)
      command.doStep
      command.memento should not be (controller.grid)
    }

    "have an undo step" in {
      val command = SetCommand.SetCommand(1, Piece(controller.currentPlayer), controller)
      command.memento should be(controller.grid)
      val starting_grid = command.memento
      command.doStep
      command.memento should not be (controller.grid)
      command.undoStep
      command.memento should not be (controller.grid)
    }
    "have a redo step" in {
      val command = SetCommand.SetCommand(1, Piece(controller.currentPlayer), controller)
      command.memento should be(controller.grid)
      command.doStep
      command.memento should not be (controller.grid)
      command.undoStep
      command.memento should not be (controller.grid)
      command.redoStep
      command.memento should not be (controller.grid)
    }
  }