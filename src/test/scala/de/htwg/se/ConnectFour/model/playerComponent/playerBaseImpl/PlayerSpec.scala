package de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * Player tests.
 */
class PlayerSpec extends AnyWordSpec with Matchers :
  "A Player" when {
    "new" should {
      val player1 = Player("Your Name", 1)
      val player2 = Player("Yo Name", 2)
      "have a name" in {
        player1.playerName should be("Your Name")
        player2.playerName should be("Yo Name")
      }
      "have a number" in {
        player1.playerNumber should be(1)
        player2.playerNumber should be(2)
      }
      "have a color" in {
        player1.color should be(Some("red"))
        player2.color should be(Some("yellow"))
      }
      "have a nice String representation" in {
        player1.toString should be
        "Der Spieler " + player1.playerName + " mit der Nummer " +
          player1.playerNumber + " hat die Farbe " + player1.color
        player2.toString should be
        "Der Spieler " + player2.playerName + " mit der Nummer " +
          player2.playerNumber + " hat die Farbe " + player2.color
      }
    }
  }