package de.htwg.se.ConnectFour.fileIOComponent

import de.htwg.se.ConnectFour.fileIOComponent.service.FileIOAPI

import scala.io.StdIn
import scala.util.{Failure, Success, Try}

object Rest {
  @main def run =
    Try(FileIOAPI) match
      case Success(_) => println("FileIO Rest Server is running!")
      case Failure(v) => println("FileIO Server couldn't be started! " + v.getMessage + v.getCause)

}
