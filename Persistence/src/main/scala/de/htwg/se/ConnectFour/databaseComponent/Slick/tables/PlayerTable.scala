package de.htwg.se.ConnectFour.databaseComponent.Slick.tables

import slick.jdbc.PostgresProfile.api.*

class PlayerTable(tag: Tag) extends Table[(Int, Int, Option[String], String)](tag, "PLAYER") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def num = column[Int]("number")
  def col = column[Option[String]]("color")
  def name = column[String]("name")

  override def * = (id, num, col, name)
}