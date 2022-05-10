package de.htwg.se.ConnectFour.databaseComponent

import com.google.inject.{Guice, Injector}
import de.htwg.se.ConnectFour.databaseComponent.Slick.DaoSlick
import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.ConnectFour.PersistenceModule
import de.htwg.se.ConnectFour.databaseComponent.DaoInterface

import scala.io.StdIn
import scala.util.{Failure, Success, Try}

object Database {
  def main(args: Array[String]): Unit = {

    val injector: Injector = Guice.createInjector(PersistenceModule())
    val database = injector.getInstance(classOf[DaoInterface])
    
    Try(database) match {
      case Success(_) => println("Slick is running!")
      case Failure(v) => println("Slick couldn't be started! " + v.getMessage + v.getCause)
    }

    database.createDB()
    println(s"Running\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    val play = Player("seb", 1)
    //database.deleteGrid()
    database.createGrid()
    println(database.updatePiece(1,1,"2"))
    database.readGrid().toPlainString
    database.resetGrid()
    database.readGrid().toPlainString
    //database.deleteGrid()
    println(database.updatePiece(1,1,"2"))
    database.readGrid().toPlainString
    //database.deleteAllPlayers()
    //StdIn.readLine() // let it run until user presses return
    //database.createPlayer(play)
    //var result = database.readPlayer(1)
    //result match
    //  case Some(v) =>
    //    print("Player Index: " + v._1)
    //    print("\nPlayer Number: " + v._2)
    //    print("\nPlayer Color: " + v._3)
    //    print("\nPlayer Name: " + v._4)
    //  case None =>

    //database.update(1, "JAJAA")
    //Thread.sleep(10000)
    //result = database.read(1)
    //print("Player Index: " + result.get._1)
    //print("\nPlayer Number: " + result.get._2)
    //print("\nPlayer Color: " + result.get._3)
    //print("\nPlayer Name: " + result.get._4)


    StdIn.readLine() // let it run until user presses return
    //val deletePlayer1 = database.delete(1)
    //print("Deletion of player 1 succeded: " + deletePlayer1.isCompleted + "\n")
    //Thread.sleep(10000)
    //print("Deletion of player 1 succeded: " + deletePlayer1.isCompleted + "\n")
  }
}