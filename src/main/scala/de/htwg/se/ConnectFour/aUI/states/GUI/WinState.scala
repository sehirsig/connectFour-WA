package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.controller.Controller
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType

import scala.io.AnsiColor

/**
 * WinState of GUI
 */
case class WinState(controller: Controller) extends State[GameState]:
  //Extension Methods
  extension (con:Controller)
    def printWinner:Unit =
      new Alert(AlertType.Information){ title = "We have a Winner!"
        headerText = "Congratulations " + controller.currentPlayer.playerName + "!!!"
        contentText = "You are the winner of this round! :)"}.showAndWait()

  override def handle(input: String, gui: GUI, state: GameState) =
    if input == "won" then
      controller.printWinner
    else if (input == "n")
      controller.reset()
      state.changeState(DropState(controller))
    end if