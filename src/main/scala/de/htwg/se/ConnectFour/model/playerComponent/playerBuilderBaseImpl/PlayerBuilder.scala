package de.htwg.se.ConnectFour.model.playerComponent.playerBuilderBaseImpl

import com.google.inject.Inject
import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.ConnectFour.model.playerComponent.{PlayerInterface, PlayerBuilderInterface}

/**
 * Player Builder implementation
 */
case class PlayerBuilder @Inject()() extends PlayerBuilderInterface :

  override def createPlayer(name: String, number: Int): PlayerInterface =
    Player(name, number)
