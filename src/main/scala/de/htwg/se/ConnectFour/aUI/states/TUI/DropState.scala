package de.htwg.se.ConnectFour.aUI.states.TUI

import de.htwg.se.ConnectFour.controller.Controller

/**
 * DropState of TUI
 */
case class DropState(controller: Controller) extends State[GameState]:

  override def handle(input: String, state: GameState) =
    val regExCheck = "([0-6])".r
    if regExCheck.matches(input) then
      controller.drop(input)
    if controller.checkWin() then
      state.changeState(WinState(controller))
      state.handle("won")
    if controller.checkWin() then
      state.changeState(WinState(controller))
    if input == "u" then
      controller.undoDrop()
    if input == "r" then
      controller.redoDrop()
    if input == "n" then
      controller.reset()
