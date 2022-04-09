package de.htwg.se.ConnectFour.model.fileIOComponent

import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

/**
 * FileIO Trait
 */
trait FileIOInterface:
  def load(controller:ControllerInterface):Unit
  def save(game: ControllerInterface): Unit