package de.htwg.se.ConnectFour.model.playerComponent

/**
 * Player Builder Trait
 * Builder pattern
 */
trait PlayerBuilderInterface:
  def createPlayer(name: String, number: Int): PlayerInterface
