package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

/**
 * DropState of GUI
 */
case class DropState(controller: ControllerInterface) extends State[GameState]:
  
  override def handle(input: String,gui:GUI, state: GameState) =
    val regExCheck = "([0-6])".r
    if regExCheck.matches(input) then
      controller.drop(input)
    if controller.checkWin() then
      state.changeState(WinState(controller))
      state.handle("won")
    input match
      case "u" => controller.undoDrop()
      case "r" => controller.redoDrop()
      case "n" => controller.reset()
      case _ =>