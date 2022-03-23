package de.htwg.se.ConnectFour.aUI.states.TUI

import de.htwg.se.ConnectFour.controller.Controller

import scala.io.AnsiColor

/**
 * WinState of TUI
 */
case class WinState(controller: Controller) extends State[GameState]:
  //Extension Methods
  extension (con:Controller)
    def printWinner(color:String):Unit = println(color + "BOOOOOOOOOOM!!!! Player " +
      con.currentPlayer.playerNumber + " called " +
      con.currentPlayer.playerName + " has won the game.")
    def printWinnerRed:Unit = printWinner(AnsiColor.RED)
    def printWinnerYellow:Unit = printWinner(AnsiColor.YELLOW)

  override def handle(input: String, state: GameState) =
    if input == "n" then
      controller.reset()
      state.changeState(DropState(controller))
    else if controller.checkWin() then
      if controller.currentPlayer.color.equals(Some("red")) then
        controller.printWinnerRed
      else
        controller.printWinnerYellow
    else
      println("Nobody has won, try playing smarter next time.")
    end if