package de.htwg.se.ConnectFour.model.player.impl

import de.htwg.se.ConnectFour.model.player.Player

/**
 * Player implementation
 */
case class PlayerImpl (playerName: String, playerNumber: Int) extends Player:

  val color: Option[String] =
    this.playerNumber match
      case 1 => Some("red")
      case 2 => Some("yellow")

  override def toString: String = "Der Spieler " + this.playerName + " mit der Nummer " +
    this.playerNumber + " hat die Farbe " + color
