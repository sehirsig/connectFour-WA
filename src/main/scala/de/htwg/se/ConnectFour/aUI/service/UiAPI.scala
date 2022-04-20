package de.htwg.se.ConnectFour.aUI.service

import akka.http.scaladsl.server.Directives.{complete, concat, get, path}
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse, StatusCode}
import akka.http.scaladsl.server.{ExceptionHandler, Route, StandardRoute}
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import tools.util.API

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success, Try}

object UiAPI:
  // needed to run the route
  val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
  given ActorSystem[Any] = system
  // needed for the future flatMap/onComplete in the end
  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext

  def apply(controller: ControllerInterface):Any =
    val uiapi = UiAPI(controller)
    val routes: String =
      """
        Welcome to the View REST service! Available routes:
          GET   /ui
          GET   /undo
          GET   /redo
          POST  /ui/[param]
        """.stripMargin

    val route = concat(
      pathSingleSlash {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, routes))
      },
      path("ui") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.grid.toJsonString))
        }
      },
      path("undo") {
        concat(
          get {
            controller.undoDrop()
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.grid.toJsonString))
          }
        )
      },
      path("redo") {
        concat(
          get {
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.grid.toJsonString))
          },
          post {
            controller.redoDrop()
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "redo success"))
          })
      },
      path("ui" / Segment) { command => {
        controller.drop(command)
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, controller.grid.toJsonString))
      }
      }
    )
    val bindingFuture = Http().newServerAt("0.0.0.0", 8080).bind(route)
    bindingFuture.onComplete {
      case Success(binding) => {
        val address = binding.localAddress
        println(s"View REST service online at http://${address.getHostName}:${address.getPort}\nPress RETURN to stop...")
      }
      case Failure(exception) => {
        println("View REST service couldn't be started! Error: " + exception + "\n")
      }
    }

  def stop(bindingFuture: Future[Http.ServerBinding]):Unit =
      bindingFuture
        .flatMap(_.unbind()) // trigger unbinding from the port
        .onComplete(_ => system.terminate()) // and shutdown when done







