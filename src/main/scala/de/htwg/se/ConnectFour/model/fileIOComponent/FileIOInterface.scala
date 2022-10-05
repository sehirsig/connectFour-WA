package de.htwg.se.ConnectFour.model.fileIOComponent

import de.htwg.se.ConnectFour.model.gridComponent.GridInterface
import de.htwg.se.ConnectFour.model.playerComponent.PlayerInterface

/**
 * FileIO Trait
 */
trait FileIOInterface:
  def load(player1:PlayerInterface, player2:PlayerInterface, grid:GridInterface):GridInterface
  def save(game: GridInterface): Unit