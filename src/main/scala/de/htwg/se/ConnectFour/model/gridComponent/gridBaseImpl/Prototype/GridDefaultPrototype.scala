package de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Prototype

import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.GridPrototype
import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Grid

import com.google.inject.Inject

class GridDefaultPrototype extends GridPrototype {
  override def cloneGrid() =
    this
}
