package de.htwg.se.ConnectFour.aUI.service

import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

/**
 * Controller for the REST User Interface.
 */
object UiController {

  def drop(controller: ControllerInterface, input: String): String =
    if !controller.checkWin() then
      controller.drop(input)
      if controller.checkWin() then
        controller.grid.toPlainString + "\n" + controller.currentPlayer.playerName + " has won the game!"
      else
        controller.grid.toPlainString
    else
      controller.currentPlayer.playerName + " has won the game! To start a new game, do /newgame"

  def redo(controller: ControllerInterface): String =
    controller.redoDrop()
    controller.grid.toPlainString

  def undo(controller: ControllerInterface): String =
    controller.undoDrop()
    controller.grid.toPlainString

  def load(controller: ControllerInterface): String =
    controller.loadGame()
    controller.grid.toPlainString

  def save(controller: ControllerInterface): String =
    controller.saveGame()
    controller.grid.toPlainString

  def newgame(controller: ControllerInterface): String =
    controller.reset()
    "New Game! Use /drop/[0-6] to start!"

  def addPlayer(controller: ControllerInterface, input: String): String =
    if controller.maxPlayers > controller.players.length then
      controller.addPlayer(input)
      "Successfully added Player: " + input
    else
      "Too many Players. You already have " + controller.players(0).playerName + " and " + controller.players(1).playerName

  def JsonToString(controller: ControllerInterface): String =
    controller.gridToJsonString()
}