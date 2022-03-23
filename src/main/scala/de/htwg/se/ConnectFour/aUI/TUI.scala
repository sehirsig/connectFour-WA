package de.htwg.se.ConnectFour.aUI

import de.htwg.se.ConnectFour.aUI.states.TUI.GameState
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.util.{Observer, UI}

import scala.io.StdIn.readLine

/**
 * ConnectFour text-based user interface
 */
case class TUI(controller: Controller) extends UI with Observer:

  controller.add(this)
  var gameState:GameState = GameState(controller)

  override def run() =
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.RED + " WELCOME TO CONNECT FOUR " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println("◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.BLUE + "Type 2 player names first." + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙")
    println(Console.BLUE + "◙◙" + Console.YELLOW + " You can start playing by typing a column number 0-6 " + Console.BLUE + "◙")
    println(Console.BLUE + "◙◙◙" + Console.YELLOW + " There is an option 'u' for undo and 'r' for redo " + Console.BLUE + "◙◙◙")
    println(Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙" + Console.GREEN + " With typing 'q' you can quit " + Console.BLUE + "◙◙◙◙◙◙◙◙◙◙◙◙◙")

    var input:String = ""
    while input != "q" do
      input = readLine()
      if !input.isEmpty then
        processInput(input)

  override def processInput(input: String) =
    input match
      case _ => execute(input)

  def execute(input:String) =
    gameState.handle(input)
  
  override def update: Boolean =
    print(this.controller.gridToString())
    true