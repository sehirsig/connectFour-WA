package de.htwg.se.ConnectFour.controller.controllerComponent
import akka.http.scaladsl.server.Directives.{complete, concat, get, path}
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport.*
import akka.http.scaladsl.model.StatusCode
import akka.http.scaladsl.server.{ExceptionHandler, Route}
import com.google.inject.{Guice, Injector}
import de.htwg.se.ConnectFour.controller.controllerComponent.controllerBaseImpl.Controller

object RootService {
  val injector: Injector = Guice.createInjector(ConnectFourModule())
  val controller = injector.getInstance(classOf[ControllerInterface])

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem(Behaviors.empty, "my-system")
    implicit val executionContext = system.executionContext
    val servicePort = 8080

    val route =
      concat (
        get {
          path("load") {
            controller.loadGame()
            complete(HttpEntity(ContentTypes.`application/json`, "loaded"))
          }
        },
        post {
          path("save") {
            controller.saveGame()
            complete(HttpEntity(ContentTypes.`application/json`, "saved"))
          }
        }
      )

    Http().newServerAt("localhost", servicePort).bind(route)
  }
}
