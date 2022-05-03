package de.htwg.se.ConnectFour.databaseComponent

import scala.concurrent.Future

trait DatabaseInterface:

  def update(id: Int, game: Future[String]) : Unit

  def delete() : Future[Any]

  def read(id: Int): Future[String]