package model.playerComponent.playerBuilderBaseImpl

import com.google.inject.Inject
import model.playerComponent.playerBaseImpl.Player
import model.playerComponent.{PlayerInterface, PlayerBuilderInterface}

/**
 * Player Builder implementation
 */
case class PlayerBuilder @Inject()() extends PlayerBuilderInterface :

  override def createPlayer(name: String, number: Int): PlayerInterface =
    Player(name, number)
