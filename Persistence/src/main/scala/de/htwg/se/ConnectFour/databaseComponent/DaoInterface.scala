package de.htwg.se.ConnectFour.databaseComponent

import de.htwg.se.ConnectFour.model.playerComponent.Player

import scala.concurrent.Future

trait DaoInterface:

  def read(playerId: Int): Option[(Int, Int, Option[String], String)]

  def update(id: Int, name: String): String

  def delete(num:Int): Future[Any]

  def createDB(): Unit

  def create(player: Player): Int

  def readAll():List[(Int, Int, Option[String], String)]

  def deleteAll(): Unit