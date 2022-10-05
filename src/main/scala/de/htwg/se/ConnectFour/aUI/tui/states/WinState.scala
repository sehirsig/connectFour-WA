package de.htwg.se.ConnectFour.aUI.tui.states

import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

import scala.io.AnsiColor

/**
 * WinState of TUI
 */
case class WinState(controller: ControllerInterface) extends State[GameState] :
  //Extension Methods
  extension (con: ControllerInterface)
    def printWinner(color: "\u001B[31m" | "\u001B[33m"): Unit = println(color + "BOOOOOOOOOOM!!!! Player " +
      con.currentPlayer.playerNumber + " called " +
      con.currentPlayer.playerName + " has won the game.")
    def printWinnerRed: Unit = printWinner(AnsiColor.RED)
    def printWinnerYellow: Unit = printWinner(AnsiColor.YELLOW)

  override def handle(input: String, state: GameState) =
    if input == "n" then
      controller.reset()
      println("New Game! Drop with typing a number between 0 - 6")
      state.changeState(DropState(controller))
    else if controller.checkWin() then
      if controller.currentPlayer.color.equals(Some("red")) then
        controller.printWinnerRed
      else
        controller.printWinnerYellow
    else
      println("Nobody has won, try playing smarter next time.")
    end if