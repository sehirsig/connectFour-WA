package de.htwg.se.ConnectFour.model.gridComponent

import de.htwg.se.ConnectFour.model.playerComponent.PlayerInterface
import netscape.javascript.JSObject
import play.api.libs.json.{JsValue, Json}

/**
 * Grid Trait
 */
trait GridInterface:
  val rows: Vector[Vector[Cell]]
  val rowCount:Int
  val colCount:Int
  def cell(row: Int, col: Int): Cell
  def replaceCell(row: Int, col: Int, cell: Cell): GridInterface
  def drop(column: Int, piece: Piece): GridInterface
  def reset(): GridInterface
  def checkWin(currentPlayer:PlayerInterface):Boolean
  def winPattern(currentPiece:Option[Piece])(rowMax:Int, colMax:Int,chipSet:(Int,Int), rowMin:Int = 0, colMin:Int = 0):Option[Boolean]
  def toJsonString(moveCount:Int, curPlayerName:String, player1Name:String, player2Name:String): String
  def toJson(moveCount:Int, curPlayerName:String, player1Name:String, player2Name:String): JsValue
  def jsonToGrid(player1:PlayerInterface, player2:PlayerInterface, par_grid:GridInterface, source: String):GridInterface
  def toPlainString:String

  