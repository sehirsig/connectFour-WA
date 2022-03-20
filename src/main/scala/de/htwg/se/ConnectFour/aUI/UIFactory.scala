package de.htwg.se.ConnectFour.aUI
import de.htwg.se.ConnectFour.aUI._
import de.htwg.se.ConnectFour.controller.Controller

object UIFactory {
  def apply(uiType:String, controller:Controller): Unit = {
    uiType.toLowerCase() match {
      case "gui" => GUI(controller).run()
      case "tui" => TUI(controller).run()
    }
  }
}
