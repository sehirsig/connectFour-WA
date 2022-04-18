package de.htwg.se.ConnectFour.controller.controllerComponent
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpMethods, HttpRequest}
import akka.http.scaladsl.server.Directives._
import com.google.inject.{Guice, Injector}
import de.htwg.se.ConnectFour.controller.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.ConnectFour.ConnectFourModule
import scala.util.{Success,Failure}

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

    val bound = Http().newServerAt("localhost", 8080).bind(route)

    bound.onComplete{
      case Success(binding) => {
        print(binding)
      }
      case Failure(exception) => {

      }
    }


  }
}
