package de.htwg.se.ConnectFour.fileIOComponent.service

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.*
import akka.http.scaladsl.server.Directives.*

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.io.StdIn
import scala.util.{Failure, Success}

object FileIOAPI:

  val connectIP = sys.env.getOrElse("FILEIO_SERVICE_HOST", "localhost").toString
  val connectPort = sys.env.getOrElse("FILEIO_SERVICE_PORT", 8081).toString.toInt


  val routes: String =
    """
        Welcome to the Persistence REST service! Available routes:
          GET   /fileio/load
          POST  /fileio/save
        """.stripMargin

  // needed to run the route
  val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
  given ActorSystem[Any] = system
  // needed for the future flatMap/onComplete in the end
  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext

  val route = concat(
    pathSingleSlash {
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, routes))
    },
    path("fileio" / "load") {
      get {
        complete(HttpEntity(ContentTypes.`application/json`, FileIOController.load()))
      }
    },
    path("fileio" / "save") {
      concat(
        post {
          entity(as[String]) { game =>
            FileIOController.save(game)
            complete("game saved")
          }
        }
      )
    }
  )


  val bindingFuture = Http().newServerAt(connectIP, connectPort).bind(route)

  bindingFuture.onComplete{
    case Success(binding) => {
      val address = binding.localAddress
      println(s"File IO REST service online at http://$connectIP:$connectPort/\nPress RETURN to stop...")

      StdIn.readLine() // let it run until user presses return
      bindingFuture
        .flatMap(_.unbind()) // trigger unbinding from the port
        .onComplete(_ => system.terminate()) // and shutdown when done
    }
    case Failure(exception) => {
      println("File IO REST service couldn't be started! Error: " + exception + "\n")
    }
  }
