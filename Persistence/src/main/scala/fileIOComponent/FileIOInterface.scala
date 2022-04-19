package fileIOComponent

//import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import model.gridComponent.GridInterface
import model.playerComponent.PlayerInterface

/**
 * FileIO Trait
 */
trait FileIOInterface:
  def load(grid:GridInterface):GridInterface
  def save(grid: GridInterface): Unit