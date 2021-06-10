package de.htwg.se.ConnectFour.model.fieldbase

import de.htwg.se.ConnectFour.model.{CannotDropPiece, ColumnFull}

import scala.util.{Failure, Success, Try}

case class GridImpl(rows: Vector[Vector[CellImpl]]) {
  def this() = this(Vector.tabulate(6, 7) { (rowCount, col) => CellImpl(None) })

  def cell(row: Int, col: Int): CellImpl = rows(row)(col)

  def replaceCell(row: Int, col: Int, cell: CellImpl): GridImpl = copy(rows.updated(row, rows(row).updated(col, cell)))

  def drop(column: Int, piece: PieceImpl): GridImpl = {
    var idx = 0
    Try(this.rows.indexWhere(row => !row(column).isSet)) match {
      case Success(result) => idx = result
      case Failure(_) => Failure(exception = new Exception)
    }

    if (idx > -1) {
      Try(this.replaceCell(idx, column, CellImpl(Some(piece)))) match {
        case Success(grid) => this.replaceCell(idx, column, CellImpl(Some(piece)))
        case Failure(_) => Failure(new CannotDropPiece); this
      }
    } else {
      Failure(new ColumnFull)
      this
    }
  }

  def reset(): GridImpl = {
    new GridImpl
  }

  override def toString: String = {
    val builder = new StringBuilder
    for (row <- this.rows.reverse) {
      for (col <- row) {
        builder.append(col)
      }
      builder.append("\n")
    }
    builder.toString()
  }
}
