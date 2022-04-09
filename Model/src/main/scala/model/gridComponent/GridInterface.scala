package model.gridComponent

import model.playerComponent.PlayerInterface

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

  