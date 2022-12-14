package de.htwg.se.ConnectFour.model.playerComponent

/**
 * Player Trait
 */
trait PlayerInterface:
  val playerNumber: Int
  val color: Option[String]
  val playerName: String
