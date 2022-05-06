package de.htwg.se.ConnectFour

import com.google.inject.{Guice, Injector}
import de.htwg.se.ConnectFour.aUI.UIFactory
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import de.htwg.se.ConnectFour.aUI.service.UiAPI
import de.htwg.se.ConnectFour.databaseComponent.Slick.DaoSlick

import scala.util.{Failure, Success, Try}

case object ConnectFour:
  @main def run =
    val injector: Injector = Guice.createInjector(ConnectFourModule())
    val controller = injector.getInstance(classOf[ControllerInterface])


    val uiType = sys.env.getOrElse("C4_UITYPE", "gui").toString

    val uiRest = sys.env.getOrElse("C4_VIEWREST", "y").toString


    uiRest match
      case "y" =>
        Try(UiAPI(controller)) match
          case Success(_) => println("View Rest Server is running!")
          case Failure(v) => println("View Rest Server couldn't be started! " + v.getMessage + v.getCause)
      case _ =>

    Try(DaoSlick) match {
      case Success(_) => println("Slick is running!")
      case Failure(v) => println("Slick couldn't be started! " + v.getMessage + v.getCause)
    }

    Try(UIFactory(uiType,controller)) match
      case Success(_) => println("See you next time! Bye.")
      case Failure(v) => println("Could not create UI: " + v.getMessage + v.getCause)

