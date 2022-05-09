package de.htwg.se.ConnectFour.databaseComponent


import de.htwg.se.ConnectFour.databaseComponent.Slick.DaoSlick
import de.htwg.se.ConnectFour.model.playerComponent.Player

import scala.io.StdIn
import scala.util.{Failure, Success, Try}

object Database {
  def main(args: Array[String]): Unit = {
    val slick = DaoSlick

    Try(slick) match {
      case Success(_) => println("Slick is running!")
      case Failure(v) => println("Slick couldn't be started! " + v.getMessage + v.getCause)
    }

    slick.create()
    println(s"Running\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    val play = Player("seb", 1)
    slick.create(play)
    val result = slick.read(1)
    print("Player Index: " + result.get._1)
    print("\nPlayer Number: " + result.get._2)
    print("\nPlayer Color: " + result.get._3)
    print("\nPlayer Name: " + result.get._4)
    StdIn.readLine() // let it run until user presses return
    val deletePlayer1 = slick.deletePlayer(1)
    print("Deletion of player 1 succeded: " + deletePlayer1.isCompleted + "\n")
    Thread.sleep(10000)
    print("Deletion of player 1 succeded: " + deletePlayer1.isCompleted + "\n")
  }
}