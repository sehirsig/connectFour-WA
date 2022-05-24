package de.htwg.se.ConnectFour.service

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.*
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.model.StatusCodes

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor, Future}
import scala.io.StdIn
import scala.util.{Failure, Success}

object RestAPI:

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
        complete(HttpEntity(ContentTypes.`application/json`, RestController.load()))
      }
    },
    path("fileio" / "save") {
      concat(
        post {
          entity(as[String]) { game =>
            RestController.save(game)
            complete("game saved")
          }
        }
      )
    },
    path("db" / "loadUI") {
      get {
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, Await.result(RestController.loadDB_UI(), Duration.Inf))) //Change here to json, to be able to load json to SRC Controller
      }
    },
    path("db" / "load") {
      get {
        complete(HttpEntity(ContentTypes.`application/json`, Await.result(RestController.loadDB(), Duration.Inf))) //Change here to json, to be able to load json to SRC Controller
      }
    },
    path("db" / "save") {
      concat(
        post {
          entity(as[String]) { game =>
            RestController.saveDB(game)
            complete("Game saved to DB")
          }
        }
      )
    },
    path("db" / "loadDAO") {
      get {
        complete(HttpEntity(ContentTypes.`application/json`, Await.result(RestController.loadDAO(),  Duration.Inf))) //Change here to json, to be able to load json to SRC Controller
      }
    },
    path("db" / "saveDAO") {
      concat(
        post {
          entity(as[String]) { game =>
            RestController.saveDAO(game)
            complete("Game saved to DB")
          }
        }
      )
    },
    path("db" / "createDAO") {
      get {
        RestController.createDAO()
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, "Database created")) //Change here to json, to be able to load json to SRC Controller
      }
    },
    path("db" / "deleteDAO") {
      get {
        RestController.deleteDAO()
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, "Database cleared.")) //Change here to json, to be able to load json to SRC Controller
      }
    },
    path("db" / "addplayer" / "1" / Segment) { command => {
       complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, RestController.addPlayer1(command).toString))
     }
    },
    path("db" / "addplayer" / "2" / Segment) { command => {
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, RestController.addPlayer2(command).toString))
      }
    },
    path("db" / "getplayer" / Segment) { command => {
       complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, Await.result(RestController.getPlayer(command), Duration.Inf).toString))
      }
    },
    path("db" / "getplayer") {
      get {
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, Await.result(RestController.getPlayers(), Duration.Inf).toString))
      }
    },
    path("db" / "deleteallplayers") {
      get {
        RestController.deleteAllPlayers()
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, "Deleted all Players"))
      }
    },
    path("db" / "deleteall") {
      get {
        RestController.deleteAll()
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, "Deleted all Tables"))
      }
    },
    path("db" / "deleteplayer" / Segment) { command => {
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, RestController.deletePlayer(command).toString))
      }
    },
    path("db" / "updateplayer" / "1" / Segment) { command => {
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, RestController.updatePlayer(1, command).toString))
      }
    }
  )


  val bindingFuture = Http().newServerAt(connectIP, connectPort).bind(route)

  RestController.createDAO()
  RestController.createDB()

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
