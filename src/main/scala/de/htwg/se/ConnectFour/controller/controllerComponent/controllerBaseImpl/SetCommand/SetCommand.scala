package de.htwg.se.ConnectFour.controller.controllerComponent.controllerBaseImpl.SetCommand

import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import model.gridComponent.{GridInterface, Piece}
import tools.util.Command

/**
 *  Command/Memento pattern implementation
 */
class SetCommand(col: Int, piece:Piece, controller: ControllerInterface) extends Command:
  var memento:GridInterface = controller.grid
  
  override def doStep =
    memento = controller.grid
    controller.setGrid(controller.grid.drop(col:Int, piece:Piece))

  override def undoStep =
    val new_memento = controller.grid //save actual grid before undo
    controller.setGrid(memento)       //reverting to old grid
    memento = new_memento             //step after

  override def redoStep =
    val new_memento = controller.grid //save actual grid before redo
    controller.setGrid(memento)       //reverting to new grid
    memento = new_memento //step before