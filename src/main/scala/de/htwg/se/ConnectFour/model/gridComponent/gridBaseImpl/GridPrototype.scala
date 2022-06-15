package de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl

/**
 * Grid Prototype class, to clone instead of creating a new object. (Performance)
 */
trait GridPrototype extends Grid {
  def cloneGrid(): Grid
}
