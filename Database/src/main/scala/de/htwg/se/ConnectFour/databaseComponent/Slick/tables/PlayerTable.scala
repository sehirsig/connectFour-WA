package de.htwg.se.ConnectFour.databaseComponent.Slick.tables

import de.htwg.se.ConnectFour.model.playerComponent.Player
import slick.jdbc.PostgresProfile.api._

class PlayerTable(tag: Tag) extends Table[(Int, Int, Option[String], String)](tag, "PLAYER") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def num = column[Int]("number")
  def col = column[Option[String]]("color")
  def name = column[String]("name")

  override def * = (id, num, col, name)
}