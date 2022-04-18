package de.htwg.se.ConnectFour.aUI
import de.htwg.se.ConnectFour.aUI.*
import de.htwg.se.ConnectFour.aUI.gui.GUI
import de.htwg.se.ConnectFour.aUI.tui.TUI
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import javafx.embed.swing.JFXPanel

object UIFactory:
  def apply(uiType:String, controller:ControllerInterface) =
    uiType.toLowerCase() match
      case "gui" =>
        JFXPanel()
        GUI(controller).run()
      case "tui" => TUI(controller).run()