package model.playerComponent.playerBaseImpl

import com.google.inject.Inject
import com.google.inject.name.Named
import model.playerComponent.PlayerInterface

/**
 * Player implementation
 */
case class Player @Inject() (@Named("Dummy")playerName: String, @Named("Eins")playerNumber: Int) extends PlayerInterface:


  val color: Option[String] =
    this.playerNumber match
      case 1 => Some("red")
      case 2 => Some("yellow")

  override def toString: String = "Der Spieler " + this.playerName + " mit der Nummer " +
    this.playerNumber + " hat die Farbe " + color
