package de.htwg.se.ConnectFour.databaseComponent

trait DAO {
  def create: Unit

  def read:String

  def update(input: String): Unit

  def delete: Unit
}
