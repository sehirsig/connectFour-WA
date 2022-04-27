package de.htwg.se.ConnectFour.fileIOComponent.service

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.*
import akka.http.scaladsl.server.Directives.*

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.io.StdIn

case object FileIOAPI {

  val connectIP = "localhost"
  val connectPort = 8081

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem(Behaviors.empty, "my-system")
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.executionContext

    val routes: String =
      """
        Welcome to the Persistence REST service! Available routes:
          GET   /fileio/load
          POST  /fileio/save
        """.stripMargin

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
              complete("Game Saved!")
            }
          }
        )
      }
    )

    val bindingFuture = Http().newServerAt(connectIP, connectPort).bind(route)

    println(s"Server online at http://$connectIP:$connectPort/\nPress RETURN to stop...")

    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done

  }
}