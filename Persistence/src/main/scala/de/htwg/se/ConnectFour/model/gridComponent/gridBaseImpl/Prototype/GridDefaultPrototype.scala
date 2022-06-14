package de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Prototype

import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.GridPrototype
import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Grid

import com.google.inject.Inject

/**
 * Grid Default class, to clone instead of creating a new object. (Performance)
 */
class GridDefaultPrototype extends GridPrototype {
  override def cloneGrid() =
    this
}
