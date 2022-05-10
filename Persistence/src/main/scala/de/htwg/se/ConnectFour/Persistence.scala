package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.service.RestAPI
import scala.util.{Failure, Success, Try}

object Persistence:
  @main def run =
    Try(RestAPI) match
      case Success(_) => println("FileIO Rest Server is running!")
      case Failure(v) => println("FileIO Server couldn't be started! " + v.getMessage + v.getCause)
