package de.htwg.se.ConnectFour.aUI.service

import akka.http.scaladsl.server.Directives.{complete, concat, get, path}
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse, StatusCode}
import akka.http.scaladsl.server.{ExceptionHandler, Route, StandardRoute}
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success, Try}

object UiAPI:

  val connectIP = sys.env.getOrElse("CONNECTFOUR_SERVICE_HOST", "localhost").toString
  val connectPort = sys.env.getOrElse("CONNECTFOUR_SERVICE_PORT", 8080).toString.toInt

  // needed to run the route
  val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "my-system")
  given ActorSystem[Any] = system
  // needed for the future flatMap/onComplete in the end
  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext

  def apply(controller: ControllerInterface) =
    val routes: String =
      """
        Welcome to the View REST service! Available routes:
          GET   /ui
          GET   /undo
          GET   /redo
          GET   /save
          GET   /load
          GET   /newgame
          GET   /addPlayer/[String]
          GET   /drop/[param]
        """.stripMargin

    val route = concat(
      pathSingleSlash {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, routes))
      },
      path("ui") {
        get {
          complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, controller.grid.toPlainString))
        }
      },
      path("undo") {
        concat(
          get {
            complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, UiController.undo(controller)))
          }
        )
      },
      path("redo") {
        concat(
          get {
            complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, UiController.redo(controller)))
          },
          post {
            complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, "redo success"))
          })
      },
      path("newgame") {
        concat(
          get {
            complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, UiController.newgame(controller)))
          }
        )
      },
      path("drop" / Segment) { command => {
          complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, UiController.drop(controller, command)))
        }
      },
      path("load") {
        concat(
          get {
            complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, UiController.load(controller)))
          }
        )
      },
      path("save") {
        concat(
          get {
            complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, UiController.save(controller)))
          }
        )
      },
      path("addPlayer" / Segment) { command => {
        complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, UiController.addPlayer(controller, command)))
      }
      }
    )

    val bindingFuture = Http().newServerAt(connectIP, connectPort).bind(route)
    bindingFuture.onComplete {
      case Success(binding) => {
        val address = binding.localAddress
        println(s"View REST service online at http://$connectIP:$connectPort/\n")
      }
      case Failure(exception) => {
        println("View REST service couldn't be started! Error: " + exception + "\n")
      }
    }







