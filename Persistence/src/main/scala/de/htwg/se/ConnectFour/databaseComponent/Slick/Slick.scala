/*
package de.htwg.se.ConnectFour.databaseComponent.Slick

import de.htwg.se.ConnectFour.databaseComponent.DatabaseInterface
import slick.jdbc.JdbcBackend.Database
import scala.concurrent.Future

class Slick extends DatabaseInterface:

  val database = Database.forURL("jdbc:postgresql://db:9005/Persistence", "postgres", "postgres", driver = "org.postgresql.Driver")

  override def update(id: Int, game: Future[String]) =
    None

  override def delete() : Future[Any] =
    None

  override def read(id: Int): Future[String] =
    ""

 */