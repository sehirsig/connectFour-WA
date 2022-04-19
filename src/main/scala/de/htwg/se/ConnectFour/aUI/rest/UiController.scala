package de.htwg.se.ConnectFour.aUI.rest

import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpMethods, HttpRequest, StatusCode}
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.http.scaladsl.marshalling.Marshal
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

import scala.util.{Failure, Success, Try}
import scala.concurrent.{Await, ExecutionContextExecutor, Future}
import scala.concurrent.duration.{Duration, DurationInt}
import model.gridComponent.GridInterface
import model.playerComponent.PlayerInterface

object UiController {

  val persistenceApiBaseUrl: String = "http://persistence:8080/"

  //implicit val system = ActorSystem(Behaviors.empty, "SingleRequest")
  //implicit val executionContext = system.executionContext

  val system: ActorSystem[Any] = ActorSystem(Behaviors.empty, "SingleRequest")
  given ActorSystem[Any] = system

  val executionContext: ExecutionContextExecutor = system.executionContext
  given ExecutionContextExecutor = executionContext

  def load(): GridInterface =
    null


  def save(controller: ControllerInterface): Boolean =
    Try (Await.result(Http().singleRequest(HttpRequest(
      uri = persistenceApiBaseUrl + "save",
      method = HttpMethods.POST,
      entity = HttpEntity(ContentTypes.`application/json`, controller.grid.toJsonString))),
      5.seconds).status) match
      case Success(status) =>
        if status.equals(StatusCode.int2StatusCode(200)) then
          true
        else
          sys.error("save request responses with status-code: " + status)
          false
      case Failure(e) =>
        sys.error("save request failed: " + e.getMessage)
        false
}