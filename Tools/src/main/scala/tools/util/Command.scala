package tools.util

/**
 * Command Trait
 * for the command pattern
 */
trait Command:
  def doStep:Unit
  def undoStep:Unit
  def redoStep:Unit