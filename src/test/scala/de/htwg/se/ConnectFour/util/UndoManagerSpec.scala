package de.htwg.se.ConnectFour.util

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class UndoManagerSpec extends AnyWordSpec with Matchers {

  "An UndoManager" should {
    val undoManager = new UndoManager

    "should do nothing on a redo or undo when stack is empty" in {
      undoManager.undoStep should be ()
      undoManager.redoStep should be ()
    }

    "have a do, undo and redo" in {
      val command = new incrCommand
      command.state should be(0)
      undoManager.doStep(command)
      command.state should be(1)
      undoManager.undoStep
      command.state should be(0)
      undoManager.redoStep
      command.state should be(1)
    }

    "handle multiple undo steps correctly" in {
      val command = new incrCommand
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
      val command = new incrCommand
      command.state should be(0)
      undoManager.undoStep
      command.state should be(0)
      undoManager.redoStep
      command.state should be(0)
    }
  }
}
