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
    print(slick.read(1))
    StdIn.readLine() // let it run until user presses return
  }
}