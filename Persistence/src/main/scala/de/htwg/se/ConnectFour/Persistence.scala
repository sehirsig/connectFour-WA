package de.htwg.se.ConnectFour

import de.htwg.se.ConnectFour.service.RestAPI
import scala.util.{Failure, Success, Try}

/**
 * Main class of the Persistence Modul, to start all services (REST-API).
 */
object Persistence:
  @main def run =
    Try(RestAPI) match
      case Success(_) => println("Persistence REST Server is running!")
      case Failure(v) => println("Persistence REST Server couldn't be started! " + v.getMessage + v.getCause)
