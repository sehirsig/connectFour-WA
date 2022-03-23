package de.htwg.se.ConnectFour.model.grid.impl

import com.google.inject.Inject
import de.htwg.se.ConnectFour.model.grid.{Cell, Grid, Piece}
import de.htwg.se.ConnectFour.model.player.Player

/**
 * Game grid implementation
 */
case class GridImpl(rows: Vector[Vector[Cell]]) extends Grid:

  @Inject()
  def this() = this(Vector.tabulate(6, 7) { (rowCount, col) => Cell(None) })

  override val colCount = 7
  override val rowCount = 6

  override def cell(row: Int, col: Int): Cell = rows(row)(col)

  override def replaceCell(row: Int, col: Int, cell: Cell): Grid = copy(rows.updated(row, rows(row).updated(col, cell)))

  override def drop(column: Int, piece: Piece): Grid =
    val idx = this.rows.indexWhere(row => !row(column).isSet)
    if (idx > -1)
      return this.replaceCell(idx, column, Cell(Some(piece)))
    this

  override def reset(): Grid =
    new GridImpl()

  override def checkWin(currentPlayer:Player):Boolean =
    val checkList:List[Option[Boolean]] = List(winPatternHorizontal(currentPlayer),winPatternVertical(currentPlayer),winPatternAscendingDiagonal(currentPlayer),winPatternDescendingDiagonal(currentPlayer))

    val win = checkList.filterNot(f => f.isEmpty).contains(Some(true))
    win

  override def winPatternHorizontal(currentPlayer:Player):Option[Boolean] =
    val currentPiece = Some(Piece(currentPlayer))
    for (i <- 0 to rowCount - 1) do
      for (j <- 0 to colCount - 4) do
        if this.cell(i, j).piece == currentPiece && this.cell(i, j + 1).piece == currentPiece && this.cell(i, j + 2).piece == currentPiece && this.cell(i, j + 3).piece == currentPiece then
          return Some(true)
    None

  override def winPatternVertical(currentPlayer:Player):Option[Boolean] =
    val currentPiece = Some(Piece(currentPlayer : Player))
    for (i <- 0 to rowCount - 3) do
      for (j <- 0 to colCount - 1) do
        if this.cell(i, j).piece == currentPiece && this.cell(i + 1, j).piece == currentPiece && this.cell(i + 2, j).piece == currentPiece && this.cell(i + 3, j).piece == currentPiece then
          return Some(true)
    None

  override def winPatternAscendingDiagonal(currentPlayer:Player):Option[Boolean] =
    val currentPiece = Some(Piece(currentPlayer))
    for (i <- 0 to rowCount - 4) do
      for (j <- 0 to colCount - 4) do
        if this.cell(i,j).piece == currentPiece && this.cell(i+1,j+1).piece == currentPiece && this.cell(i+2,j+2).piece == currentPiece && this.cell(i+3,j+3).piece == currentPiece then
          return Some(true)
    None

  override def winPatternDescendingDiagonal(currentPlayer:Player):Option[Boolean] =
    val currentPiece = Some(Piece(currentPlayer))
    for (i <- 3 to rowCount - 1) do
      for (j <- 0 to colCount - 3) do
        if this.cell(i, j).piece == currentPiece && this.cell(i - 1, j + 1).piece == currentPiece && this.cell(i - 2, j + 2).piece == currentPiece && this.cell(i - 3, j + 3).piece == currentPiece then
          return Some(true)
    None

  override def toString: String =
    var empty = true
    for row <- this.rows do
      for col <- row do
        if (col.isSet)
          empty = false

    if !empty then
      val builder = new StringBuilder
      for row <- this.rows.reverse do
        for (col <- row) do
          builder.append(col)
        builder.append("\n")
      return builder.toString()
    ""
