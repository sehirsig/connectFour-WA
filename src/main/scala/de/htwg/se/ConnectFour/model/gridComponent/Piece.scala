package de.htwg.se.ConnectFour.model.gridComponent

import de.htwg.se.ConnectFour.model.playerComponent.PlayerInterface

/**
 * Piece case class
 */
case class Piece(player: PlayerInterface):
  override def toString: String =
    player.playerNumber match
      case 1 => Console.RED + "☻ "
      case 2 => Console.YELLOW + "☻ "
