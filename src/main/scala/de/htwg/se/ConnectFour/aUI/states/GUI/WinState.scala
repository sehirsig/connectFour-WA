package de.htwg.se.ConnectFour.aUI.states.GUI

import de.htwg.se.ConnectFour.aUI.GUI
import de.htwg.se.ConnectFour.controller.Controller
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType

/**
 * WinState of GUI
 */
case class WinState(controller: Controller) extends State[GameState]:

  override def handle(input: String, gui: GUI, state: GameState) =
    if input == "won" then
      if controller.currentPlayer.color.equals("red") then
        new Alert(AlertType.Information){ title = "We have a Winner!"
          headerText = "Congratulations " + controller.currentPlayer.playerName + "!!!"
          contentText = "you are the winner of this round! :)"}.showAndWait()
      else
        new Alert(AlertType.Information){ title = "We have a Winner!"
          headerText = "Congratulations " + controller.currentPlayer.playerName + "!!!"
          contentText = "you are the winner of this round! :)"}.showAndWait()
      end if
    else if (input == "n")
      controller.reset()
      state.changeState(DropState(controller))
    end if