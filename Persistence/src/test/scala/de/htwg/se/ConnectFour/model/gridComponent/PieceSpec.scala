package de.htwg.se.ConnectFour.model.gridComponent

import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * Piece tests.
 */
class PieceSpec extends AnyWordSpec with Matchers:
  "A Piece" when {
    "new" should {
      val player1 = Player("Your Name", 1)
      val player2 = Player("Your Name", 2)
      val piece1 = Piece(player1)
      val piece2 = Piece(player2)
      "have a color" in {
        piece1.toString should be (Console.RED + "☻ ")
        piece2.toString should be (Console.YELLOW + "☻ ")
      }
      "have a plain String represntation" in {
        piece1.toPlainString should be ("© ")
        piece2.toPlainString should be ("® ")
      }
    }
  }