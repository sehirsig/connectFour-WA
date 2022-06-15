package de.htwg.se.ConnectFour.aUI.gui.states

import de.htwg.se.ConnectFour.aUI.gui.GUI

/**
 * State Trait
 * Implementation of State
 * pattern in the GUI package
 */
trait State[T]:
  def handle(input: String, gui: GUI, state: T): Unit