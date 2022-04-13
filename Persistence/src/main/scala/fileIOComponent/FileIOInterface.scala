package fileIOComponent

//import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import model.gridComponent.GridInterface
import model.playerComponent.PlayerInterface

/**
 * FileIO Trait
 */
trait FileIOInterface:
  def load(player1:PlayerInterface, player2:PlayerInterface, grid:GridInterface):GridInterface
  def save(game: GridInterface): Unit