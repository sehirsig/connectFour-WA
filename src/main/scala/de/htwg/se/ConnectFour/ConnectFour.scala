package de.htwg.se.ConnectFour

import com.google.inject.{Guice, Injector}
import de.htwg.se.ConnectFour.aUI.UIFactory
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import de.htwg.se.ConnectFour.aUI.service.UiAPI

import scala.util.{Failure, Success, Try}

case object ConnectFour:
  @main def run =
    val injector: Injector = Guice.createInjector(ConnectFourModule())
    val controller = injector.getInstance(classOf[ControllerInterface])

    var uiType = "gui"
    sys.env.get("C4_UITYPE") match
      case Some(v) => uiType = v
      case _ =>

    sys.env.get("C4_VIEWREST") match
      case Some(v) if v == "n" =>
      case _ =>
        Try(UiAPI(controller)) match
          case Success(_) => println("View Rest Server is running!")
          case Failure(v) => println("View Rest Server couldn't be started! " + v.getMessage + v.getCause)

    Try(UIFactory(uiType,controller)) match
      case Success(_) => println("See you next time! Bye.")
      case Failure(v) => println("Could not create UI: " + v.getMessage + v.getCause)

