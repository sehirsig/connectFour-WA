package de.htwg.se.ConnectFour.fileIOComponent

/**
 * FileIO Trait
 */
trait FileIOInterface:
  def load(): String

  def save(gameAsText: String): Unit