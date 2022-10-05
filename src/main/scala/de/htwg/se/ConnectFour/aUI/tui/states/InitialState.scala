package de.htwg.se.ConnectFour.aUI.tui.states

import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

/**
 * InitialState of TUI
 */
case class InitialState(controller: ControllerInterface) extends State[GameState] :
  override def handle(input: String, state: GameState) =
    if controller.players.size == controller.maxPlayers then
      controller.currentPlayer = controller.players(0)
      if input != "q" then
        state.changeState(DropState(controller))
      else if controller.players.size < 3 && input != "q" then
        controller.addPlayer(input)
      println("Player " + controller.players.size + " is called: " + input)
      if controller.players.size == 2 then
        println("Type 0 - 6 to drop a piece")
        state.changeState(DropState(controller))
    end if