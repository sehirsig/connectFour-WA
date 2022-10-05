package de.htwg.se.ConnectFour

import com.google.inject.{Guice, Injector}
import de.htwg.se.ConnectFour.aUI.UIFactory
import de.htwg.se.ConnectFour.aUI.service.UiAPI
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface

import scala.util.{Failure, Success, Try}

/**
 * Main class of the project.
 */
case object ConnectFour:
  @main def run =
    val injector: Injector = Guice.createInjector(ConnectFourModule())
    val controller = injector.getInstance(classOf[ControllerInterface])

    val uiType = sys.env.getOrElse("C4_UITYPE", "gui").toString //Changeable to "gui" or "tui"
    val uiRest = sys.env.getOrElse("C4_VIEWREST", "y").toString //"y", if the ViewREST API should be loaded.
    val serverStatus = sys.env.getOrElse("C4_MODE", "offline").toString //"offline", then REST from SA should be deactivated

    serverStatus match
      case "offline" =>
      case _ =>
        uiRest match
          case "y" =>
            Try(UiAPI(controller)) match
              case Success(_) => println("View Rest Server is running!")
              case Failure(v) => println("View Rest Server couldn't be started! " + v.getMessage + v.getCause)
          case _ =>

    Try(UIFactory(uiType, controller)) match
      case Success(_) => println("See you next time! Bye.");System.exit(0)
      case Failure(v) => println("Could not create UI: " + v.getMessage + v.getCause)
