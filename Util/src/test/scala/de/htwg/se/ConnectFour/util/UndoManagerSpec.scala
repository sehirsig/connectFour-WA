package de.htwg.se.ConnectFour.util

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * UndoManager tests.
 */
class UndoManagerSpec extends AnyWordSpec with Matchers:
  "An UndoManager" should {
    val undoManager = UndoManager()

    "have a do, undo and redo" in {
      val command = incrCommand()
      undoManager.undoStep
      undoManager.redoStep
      command.state should be(0)
      undoManager.doStep(command)
      command.state should be(1)
      undoManager.undoStep
      command.state should be(0)
      undoManager.redoStep
      command.state should be(1)
    }

    "handle multiple undo steps correctly" in {
      val command = incrCommand()
      command.state should be(0)
      undoManager.doStep(command)
      command.state should be(1)
      undoManager.doStep(command)
      command.state should be(2)
      undoManager.undoStep
      command.state should be(1)
      undoManager.undoStep
      command.state should be(0)
      undoManager.redoStep
      command.state should be(1)
    }
    "do nothing" in {
      val command = incrCommand()
      command.state should be(0)
      undoManager.undoStep
      command.state should be(0)
      undoManager.redoStep
      command.state should be(0)
    }
  }