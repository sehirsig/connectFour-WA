package de.htwg.se.ConnectFour.databaseComponent

import scala.concurrent.Future

trait DAOInterface {
  def create: Unit

  def read: Future[String]

  def update(input: String): Unit

  def delete: Unit
}
