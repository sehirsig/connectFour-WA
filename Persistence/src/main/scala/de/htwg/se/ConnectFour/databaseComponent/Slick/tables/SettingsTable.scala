package de.htwg.se.ConnectFour.databaseComponent.Slick.tables

import slick.jdbc.PostgresProfile.api.*

/**
 * Settings Table for SQL.
 */
class SettingsTable(tag: Tag) extends Table[(Int, String, Int)](tag, "SETTINGS") {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def currplayer = column[String]("currplayer")
  def movecount = column[Int]("movecount")

  //def userFK = //Foreign Key to join Player and Settings Current Player
    //foreignKey("currplayer_fk", currplayer, TableQuery[PlayerTable])(_.name, ForeignKeyAction.Restrict, ForeignKeyAction.Cascade)

  override def * = (id, currplayer, movecount)
}