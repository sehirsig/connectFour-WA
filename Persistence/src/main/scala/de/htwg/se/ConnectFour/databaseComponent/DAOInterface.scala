package de.htwg.se.ConnectFour.databaseComponent

trait DAOInterface {
  def create: Unit

  def read:String

  def update(input: String): Unit

  def delete: Unit
}
