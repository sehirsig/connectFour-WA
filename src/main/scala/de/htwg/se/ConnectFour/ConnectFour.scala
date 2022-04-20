package de.htwg.se.ConnectFour

import com.google.inject.{Guice, Injector}
import de.htwg.se.ConnectFour.aUI.UIFactory
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import de.htwg.se.ConnectFour.aUI.service.UiAPI
import fileIOComponent.service.FileIOAPI

import scala.util.{Failure, Success, Try}

case object ConnectFour:
  @main def run =
    val injector: Injector = Guice.createInjector(ConnectFourModule())
    val controller = injector.getInstance(classOf[ControllerInterface])
    val uiType = "gui"
    Try(UiAPI(controller)) match
      case Success(v) => println("View Rest Server is running!")
      case Failure(v) => println("View Rest Server couldn't be started! " + v.getMessage + v.getCause)
    Try(FileIOAPI) match
      case Success(v) => println("Persistance Rest Server is running!")
      case Failure(v) => println("Persistance Server couldn't be started! " + v.getMessage + v.getCause)

    Try(UIFactory(uiType,controller)) match
      case Success(v) => println("See you next time! Bye.")
      case Failure(v) => println("Could not create UI: " + v.getMessage + v.getCause)
