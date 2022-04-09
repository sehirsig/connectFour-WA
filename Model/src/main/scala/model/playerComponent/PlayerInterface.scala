package model.playerComponent

/**
 * Player Trait
 */
trait PlayerInterface:
  val playerNumber: Int
  val color: Option[String]
  val playerName: String
