package de.htwg.se.ConnectFour.service

import com.google.inject.{Guice, Inject, Injector}
import de.htwg.se.ConnectFour.PersistenceModule
import de.htwg.se.ConnectFour.fileIOComponent.FileIOInterface
import com.google.inject.name.Names
import de.htwg.se.ConnectFour.databaseComponent.DaoInterface
import de.htwg.se.ConnectFour.model.playerComponent.Player

import java.io.*
import scala.io.Source

object RestController:

  val injector: Injector = Guice.createInjector(PersistenceModule())
  val fileIO = injector.getInstance(classOf[FileIOInterface])
  val database = injector.getInstance(classOf[DaoInterface])

  def load(): String =
    fileIO.load()

  def save(gameAsText: String) =
    fileIO.save(gameAsText)

  def deletePlayer(input:String) =
    database.delete(input.toInt)

  def addPlayer1(input:String) =
    val play = Player(input, 1)
    database.create(play)

  def addPlayer2(input:String) =
    val play = Player(input, 2)
    database.create(play)

  def getPlayer(input:String): Option[(Int, Int, Option[String], String)]=
    database.read(input.toInt)

  def createDB() =
    database.createDB()

  def updatePlayer(num:Int, name:String) =
    database.update(num, name)

  def getPlayers():String=
    database.readAll().toString()

  def deleteAllPlayers() =
    database.deleteAll()