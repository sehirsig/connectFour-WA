package de.htwg.se.ConnectFour.model.gridComponent

import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.ConnectFour.model.playerComponent.playerBuilderBaseImpl.PlayerBuilder
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * Cell tests.
 */
class CellSpec extends AnyWordSpec with Matchers:
  "A Cell" when {
    "not set to any value " should {
      val emptyCell = Cell(None)
      "have value 0" in {
        emptyCell.piece should be(None)
      }
      "not be set" in {
        emptyCell.isSet should be(false)
      }
      "have a nice String representation" in {
        emptyCell.toString should be (Console.BLUE + "_ ")
      }
      "have a plain String representation" in {
        emptyCell.toPlainString should be ("_ ")
      }
    }
    "set to a specific value" should {
      val playerBuilder = PlayerBuilder()
      val player = playerBuilder.createPlayer("Your Name",1)
      val nonEmptyCell = Cell(Some(Piece(player)))
      "return that value" in {
        nonEmptyCell.piece should be(Some(Piece(Player("Your Name",1))))
      }
      "be set" in {
        nonEmptyCell.isSet should be(true)
      }
      "have a nice String representation" in {
        nonEmptyCell.toString should be (Console.RED + "☻ ")
      }
      "have a plain String representation" in {
        nonEmptyCell.toPlainString should be ("© ")
      }
    }
  }