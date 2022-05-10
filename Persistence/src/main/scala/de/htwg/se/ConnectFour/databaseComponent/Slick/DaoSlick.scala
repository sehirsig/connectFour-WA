package de.htwg.se.ConnectFour.databaseComponent.Slick

import com.google.inject.Inject
import de.htwg.se.ConnectFour.databaseComponent.DaoInterface
import de.htwg.se.ConnectFour.databaseComponent.Slick.tables.PlayerTable
import de.htwg.se.ConnectFour.model.playerComponent.Player
//import slick.driver.PostgresDriver.api.*
import slick.jdbc.JdbcBackend.Database
import slick.lifted.TableQuery
import slick.jdbc.PostgresProfile.api.*

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, DurationInt}
import scala.concurrent.{Await, Future}
import scala.io.StdIn
import scala.util.{Failure, Success, Try}

class DaoSlick @Inject () extends DaoInterface:

  val connectIP = sys.env.getOrElse("POSTGRES_IP", "localhost").toString
  val connectPort = sys.env.getOrElse("POSTGRES_PORT", 5432).toString.toInt
  val database_user = sys.env.getOrElse("POSTGRES_USER", "postgres").toString
  val database_pw = sys.env.getOrElse("POSTGRES_PASSWORD", "postgres").toString
  val database_name = sys.env.getOrElse("POSTGRES_DB", "postgres").toString

  val database =
    Database.forURL(
      url = "jdbc:postgresql://" + connectIP + ":" + connectPort + "/" + database_name + "?serverTimezone=UTC",
      user = database_user,
      password = database_pw,
      driver = "org.postgresql.Driver")

  val playerTable = TableQuery[PlayerTable]

  //Create Database
  //Await.result(database.run(playerTable.schema.createIfNotExists), Duration.Inf)

  override def createDB(): Unit =
    val d = Future(Await.result(database.run(playerTable.schema.createIfNotExists), Duration.Inf))
    d.onComplete {
      case Success(_) => print("Connection to database worked!")
      case Failure(e) => print("Error: " + e)
    }

  override def read(playerId: Int): Option[(Int, Int, Option[String], String)] =
    val actionQuery = sql"""SELECT * FROM "PLAYER" WHERE "number" = $playerId""".as[(Int, Int, Option[String], String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result match {
      case Seq(a) => Some((a._1, a._2, a._3, a._4))
      case _ => None
    }

  override def update(id: Int, name: String):String  =
    if read(id) == None then
      return "Player non existent."
    val actionQuery =
      sql"""UPDATE "PLAYER" SET "number" = id, "name" = $name WHERE "number" = $id""".as[(Int, Int, Option[String], String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result.toString()

  override def delete(num:Int): Future[Any] =
    val action = playerTable.filter(_.id === num ).delete
    Future(Await.result(database.run(action), atMost = 10.second))

  override def create(player: Player): Int =
    if readAll().length > 1 then
      return -1
    Try({
      database.run(playerTable += (1, player.playerNumber, player.color, player.playerName))
      player.playerNumber
    }) match {
      case Success(_) =>
        println("Geklappt");player.playerNumber
      case Failure(exception) => println(exception); -1
    }

  override def readAll(): List[(Int, Int, Option[String], String)] =
    val actionQuery = sql"""SELECT * FROM "PLAYER"""".as[(Int, Int, Option[String], String)]
    val result = Await.result(database.run(actionQuery), atMost = 10.second)
    result.toList

  override def deleteAll() =
    val action = playerTable.delete
    Future(Await.result(database.run(action), atMost = 10.second))


