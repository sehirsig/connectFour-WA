package de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.Prototype

import com.google.inject.Inject
import de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl.{Grid, GridPrototype}

/**
 * Grid Default class, to clone instead of creating a new object. (Performance)
 */
class GridDefaultPrototype extends GridPrototype {
  override def cloneGrid() =
    this
}
