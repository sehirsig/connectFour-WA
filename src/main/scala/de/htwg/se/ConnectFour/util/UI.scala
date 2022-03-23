package de.htwg.se.ConnectFour.util

/**
 * UI Trait
 * Template pattern
 */
trait UI:
  def processInput(input: String): Unit
  def run(): Unit
