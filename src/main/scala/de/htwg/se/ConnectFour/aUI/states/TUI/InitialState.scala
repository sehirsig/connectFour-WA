package de.htwg.se.ConnectFour.aUI.states.TUI

import de.htwg.se.ConnectFour.controller.Controller

/**
 * InitialState of TUI
 */
case class InitialState(controller: Controller) extends State[GameState]:
  override def handle(input: String, state: GameState) =
    if controller.players.size == controller.maxPlayers then
      controller.currentPlayer = controller.players(0)
      if input != "q" then
        state.changeState(DropState(controller))
    else if controller.players.size < 3 && input != "q" then
      controller.addPlayer(input)
      println("Player " + controller.players.size + " is called: " + input)
      if controller.players.size == 2 then
        state.changeState(DropState(controller))
    end if