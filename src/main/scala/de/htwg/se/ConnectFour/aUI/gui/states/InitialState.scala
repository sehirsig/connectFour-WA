package de.htwg.se.ConnectFour.aUI.gui.states

import de.htwg.se.ConnectFour.aUI.gui.GUI
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

/**
 * InitialState of GUI
 */
case class InitialState(controller: ControllerInterface, gui: GUI) extends State[GameState] :
  override def handle(input: String, gui: GUI, state: GameState) =
    if controller.players.size == controller.maxPlayers then
      state.changeState(DropState(controller))
      gui.refreshView()
      controller.currentPlayer = controller.players(0)