package de.htwg.se.ConnectFour.model.grid

import de.htwg.se.ConnectFour.model.player.Player

/**
 * Grid Trait
 */
trait Grid:
  val rows: Vector[Vector[Cell]]
  val rowCount:Int
  val colCount:Int
  def cell(row: Int, col: Int): Cell
  def replaceCell(row: Int, col: Int, cell: Cell): Grid
  def drop(column: Int, piece: Piece): Grid
  def reset(): Grid
  def checkWin(currentPlayer:Player):Boolean
  def winPattern(currentPiece:Option[Piece])(rowMax:Int, colMax:Int,chipSet:(Int,Int), rowMin:Int = 0, colMin:Int = 0):Option[Boolean]
  def checkP(currentPiece:Option[Piece])(firstChip:(Int,Int), chipSet:(Int,Int)):Boolean
  