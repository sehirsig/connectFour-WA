package de.htwg.se.ConnectFour.databaseComponent

import de.htwg.se.ConnectFour.model.playerComponent.Player

import scala.concurrent.Future

trait DatabaseInterface {

  def read(playerId: Int): Option[(Int, Int, Option[String], String)]

  def update(id: Int, game: Future[String]): Unit

  def deletePlayer(num:Int): Future[Any]

  def create(): Unit

  def create(player: Player): Option[Int]
}