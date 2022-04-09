package model.gridComponent

import model.gridComponent
import model.gridComponent.Piece
import model.playerComponent.playerBaseImpl.Player
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PieceSpec extends AnyWordSpec with Matchers:
  "A Piece" when {
    "new" should {
      val player1 = Player("Your Name", 1)
      val player2 = Player("Your Name", 2)
      val piece1 = gridComponent.Piece(player1)
      val piece2 = gridComponent.Piece(player2)
      "have a color" in {
        piece1.toString should be (Console.RED + "☻ ")
        piece2.toString should be (Console.YELLOW + "☻ ")
      }
    }
  }