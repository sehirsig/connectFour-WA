package de.htwg.se.ConnectFour.service

import com.google.inject.{Guice, Inject, Injector}
import de.htwg.se.ConnectFour.PersistenceModule
import de.htwg.se.ConnectFour.fileIOComponent.FileIOInterface
import com.google.inject.name.Names
import de.htwg.se.ConnectFour.databaseComponent.DBInterface
import de.htwg.se.ConnectFour.databaseComponent.DAOInterface
import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player

import java.io.*
import scala.io.Source

object RestController:

  val injector: Injector = Guice.createInjector(PersistenceModule())
  val fileIO = injector.getInstance(classOf[FileIOInterface])
  val database = injector.getInstance(classOf[DBInterface])
  val databaseDAO = injector.getInstance(classOf[DAOInterface])

  def load(): String =
    databaseDAO.read//fileIO.load() //Test Database databaseDAO.read

  def save(gameAsText: String) =
    fileIO.save(gameAsText)

  def loadDB_UI(): String =
    database.loadGrid_UI()

  def loadDB(): String =
    database.loadGrid()

  def saveDB(grid:String) =
    database.updateGrid(grid)

  def deletePlayer(input:String) =
    database.deletePlayer(input.toInt)

  def addPlayer1(input:String) =
    val play = Player(input, 1)
    database.createPlayer(play)

  def addPlayer2(input:String) =
    val play = Player(input, 2)
    database.createPlayer(play)

  def getPlayer(input:String): Option[(Int, Int, Option[String], String)]=
    database.readPlayer(input.toInt)

  def createDB() =
    database.createDB()

  def updatePlayer(num:Int, name:String) =
    database.updatePlayer(num, name)

  def getPlayers():String=
    database.readAllPlayers().toString()

  def deleteAllPlayers() =
    database.deleteAllPlayers()

  def createDAO(): Unit =
    databaseDAO.create

  def deleteDAO(): Unit =
    databaseDAO.delete

  def loadDAO(): String =
    databaseDAO.read

  def saveDAO(input:String) =
    databaseDAO.update(input)

  def deleteAll() =
    database.deleteAllPlayers()
    database.deleteGrid()