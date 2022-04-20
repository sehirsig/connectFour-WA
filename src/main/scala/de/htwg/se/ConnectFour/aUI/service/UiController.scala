package de.htwg.se.ConnectFour.aUI.service

import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

object UiController {

  def drop(controller: ControllerInterface, input: String) =
    controller.drop(input)

  def redo(controller: ControllerInterface) =
    controller.redoDrop()

  def undo(controller: ControllerInterface) =
    controller.undoDrop()

  def newgame(controller: ControllerInterface) =
    controller.reset()

  def JsonToString(controller: ControllerInterface):String =
    controller.grid.toJsonString
}