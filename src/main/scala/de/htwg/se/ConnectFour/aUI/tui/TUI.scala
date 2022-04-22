package de.htwg.se.ConnectFour.aUI.tui

import de.htwg.se.ConnectFour.aUI.tui.states.GameState
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import de.htwg.se.ConnectFour.util.{Observer, UI}

import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}

/**
 * ConnectFour text-based user interface
 */
case class TUI(controller: ControllerInterface) extends UI with Observer :

  controller.add(this)
  var gameState: GameState = GameState(controller)

  override def run() =
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.RED + " WELCOME TO CONNECT FOUR " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println("◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.BLUE + "Type 2 player names first." + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println(Console.BLUE + "◙◙" + Console.YELLOW + " You can start playing by typing a column number 0-6 " + Console.BLUE + "◙")
    println(Console.BLUE + "◙◙◙" + Console.YELLOW + " There is an option 'u' for undo and 'r' for redo " + Console.BLUE + "◙◙◙")
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.GREEN + " With typing 'q' you can quit " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙")
    selectInput

  def selectInput: Unit =
    val input = readLine()
    input match
      case _ if input.isEmpty => selectInput
      case "q" =>
      case _ if !input.isEmpty => processInput(input); selectInput

  override def processInput(input: String) =
    input match
      case _ => execute(input)

  def execute(input: String) =
    gameState.handle(input)

  override def update: Boolean =
    Try(println(this.controller.gridToString())) match
      case Success(v) => true
      case Failure(v) => false
