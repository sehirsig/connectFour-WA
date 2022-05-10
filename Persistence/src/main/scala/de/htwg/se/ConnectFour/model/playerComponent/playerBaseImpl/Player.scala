package de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl

/**
 * Player implementation
 */
case class Player(playerName: String, playerNumber: Int):

  val color: Option[String] =
    this.playerNumber match
      case 1 => Some("red")
      case 2 => Some("yellow")

  override def toString: String = "Der Spieler " + this.playerName + " mit der Nummer " +
    this.playerNumber + " hat die Farbe " + color
