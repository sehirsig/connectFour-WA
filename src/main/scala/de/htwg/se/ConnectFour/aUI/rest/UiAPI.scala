package de.htwg.se.ConnectFour.aUI.rest

import akka.http.scaladsl.server.Directives.{complete, concat, get, path}
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.model.{HttpResponse, StatusCode, ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{ExceptionHandler, Route, StandardRoute}
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

import scala.concurrent.ExecutionContextExecutor
import scala.util.{Failure, Success, Try}

class UiAPI(controller: ControllerInterface) {
  val routes: String =
    """
        Welcome to the ui-service! Available routes:
          GET   /persistence/load
          POST  /persistence/save
        """.stripMargin

  // needed to run the route
  val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
  given ActorSystem[Any] = system
  // needed for the future flatMap/onComplete in the end
  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext

  //val route = Route.seal(
  //  concat(
  //    (get & path("")) {
  //      complete(routes)
  //    },
  //    (get & path("persistence" / "load")) {
  //      Try(UiController.load()) match
  //        case Success(v) => complete(v.toJsonString)
  //        case Failure(_) => complete(StatusCode.int2StatusCode(200))
  //    },
  //    (post & path("persistence" / "save")) {
  //      Try(UiController.save(controller)) match
  //        case Success(v) => complete(StatusCode.int2StatusCode(100))
  //        case Failure(_) => complete(StatusCode.int2StatusCode(200))
  //    }
  //  )
  //)
  //val route: Route = get {
  //  pathSingleSlash {
  //    complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, "<h1>ConnectFour</h1>"))
  //  }
  //  path("ui") {
  //    gridtoJson
  //  } ~
  //    path("ui" / "undo") {
  //      controller.undoDrop()
  //      gridtoJson
  //    } ~
  //    path("ui" / "redo") {
  //      controller.redoDrop()
  //      gridtoJson
  //    } ~
  //    path("ui" / Segment) { command =>
  //      {
  //        processInputLine(command)
  //        gridtoJson
  //      }
  //    }
  //}

  val route = concat(
    pathSingleSlash {
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>ConnectFour</h1>"))
    },
    path("ui") {
      get {
        gridtoJson
      }
    },
    path("undo") {
      concat(
        get {
          controller.undoDrop()
          gridtoJson
        }//,
        //post {
        //  //controller.undoDrop()
        //  //complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "undo success"))
        //}
      )
    },
    path("redo") {
      concat(
        get {
          gridtoJson
        },
        post {
          controller.redoDrop()
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "redo success"))
        })
    },
    path("ui" / Segment) { command =>
      {
        processInputLine(command)
        gridtoJson
      }
    }
  )

  def gridtoJson: StandardRoute = {
    complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>ConnectFour</h1>" + controller.grid.toJsonString))
  }

  def processInputLine(input: String): Unit = {
    controller.drop(input)
  }

  val bindingFuture = Http().newServerAt("0.0.0.0", 8080).bind(route)
  println(s"View server online at http://localhost:8080/\nPress RETURN to stop...")

  def stop():Unit =
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
}
