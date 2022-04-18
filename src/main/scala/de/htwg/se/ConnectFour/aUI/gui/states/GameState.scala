package de.htwg.se.ConnectFour.aUI.gui.states

import de.htwg.se.ConnectFour.aUI.gui.GUI
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

/**
 * GameState of GUI
 */
case class GameState(controller: ControllerInterface, gui:GUI):
  var state: State[GameState] = InitialState(controller, gui)

  def handle(input: String) =
    state.handle(input, gui, this)

  def changeState(state: State[GameState]) =
    this.state = state
    state.handle("",gui,this)