package de.htwg.se.ConnectFour.databaseComponent.Slick.tables

import de.htwg.se.ConnectFour.model.playerComponent.Player
import slick.jdbc.PostgresProfile.api.*

class GridTable(tag: Tag) extends Table[(Int, Int, Int, Option[String])](tag, "PLAYER") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def row = column[Int]("row")
  def col = column[Int]("column")
  def value = column[Option[String]]("value")

  override def * = (id, row, col, value)
}