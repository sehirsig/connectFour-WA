package de.htwg.se.ConnectFour

import com.google.inject.{Guice, Injector}
import de.htwg.se.ConnectFour.aUI.UIFactory
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

import scala.util.{Failure, Success, Try}

case object ConnectFour:
  @main def run =
    val injector: Injector = Guice.createInjector(ConnectFourModule())
    val controller = injector.getInstance(classOf[ControllerInterface])
    val uiType = "gui"

    Try(UIFactory(uiType,controller)) match
      case Success(v) => println("See you next time! Bye.")
      case Failure(v) => println("Could not create UI: " + v.getMessage + v.getCause)