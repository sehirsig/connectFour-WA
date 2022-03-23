package de.htwg.se.ConnectFour.aUI.states.TUI

import de.htwg.se.ConnectFour.controller.Controller

/**
 * WinState of TUI
 */
case class WinState(controller: Controller) extends State[GameState]:
  override def handle(input: String, state: GameState) =
    if controller.checkWin() then
      if controller.currentPlayer.color.equals("red") then
        println(Console.RED + "BOOOOOOOOOOM!!!! Player " +
          controller.currentPlayer.playerNumber + " called " +
          controller.currentPlayer.playerName + " has won the game.")
      else
        println(Console.YELLOW + "BOOOOOOOOOOM!!!! Player " +
          controller.currentPlayer.playerNumber + " called " +
          controller.currentPlayer.playerName + " has won the game.")
    else
      println("Nobody has won, try playing smarter next time.")