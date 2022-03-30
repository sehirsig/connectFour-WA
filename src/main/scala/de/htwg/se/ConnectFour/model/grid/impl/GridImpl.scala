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
    val horizontal = winPattern(Some(Piece(currentPlayer)))(rowCount - 1,colCount - 4,(0,1))
    val vertical = winPattern(Some(Piece(currentPlayer)))(rowCount - 3,colCount - 1,(1,0))
    val ascendingDiagonal = winPattern(Some(Piece(currentPlayer)))(rowCount - 4,colCount - 4,(1,1))
    val descendingDiagonal = winPattern(Some(Piece(currentPlayer)))(rowCount - 1,colCount - 3,(-1,1), 3)
    val checkList:List[Option[Boolean]] = List(horizontal,vertical,ascendingDiagonal,descendingDiagonal)

    val win = checkList.filterNot(_.isEmpty).contains(Some(true))
    win

  def winPattern(currentPiece:Option[Piece])(rowMax:Int, colMax:Int,chipSet:(Int,Int), rowMin:Int = 0, colMin:Int = 0):Option[Boolean] =
    //idx = rowMin für descendingDiagonla, damit idx bei rowMin anfängt!
    if goThroughRow(currentPiece)(rowMin,rowMax,colMin, colMax,rowMin, chipSet) == Some(true) then
      Some(true)
    else
      None

  def goThroughRow(currentPiece:Option[Piece])(rowMin:Int,rowMax:Int, colMin:Int, colMax:Int, idx:Int,chipSet:(Int,Int)):Option[Boolean] =
    if rowMax < idx || rowMin > idx then
      Some(false)
    else if goThroughCol(currentPiece)(colMin, colMax,0,idx, chipSet) == Some(true) then
      Some(true)
    else if goThroughRow(currentPiece)(rowMin, rowMax, colMin, colMax, idx + 1, chipSet) == Some(true) then
      Some(true)
    else
      Some(false)

  def goThroughCol(currentPiece:Option[Piece])(min:Int,max:Int,idx:Int,rowIdx:Int,chipSet:(Int,Int)):Option[Boolean] =
    if max < idx || min > idx then
      Some(false)
    else if checkP(currentPiece)((rowIdx,idx), chipSet) then
      Some(true)
    else
      goThroughCol(currentPiece)(min, max, idx + 1, rowIdx, chipSet)

  extension (b:(Int,Int))
    def add(c:(Int,Int)):(Int,Int)=
      (b._1 + c._1, b._2 + c._2)
    def multi(d:Int):(Int,Int)=
      (b._1 * d, b._2 * d)

  def checkP(currentPiece:Option[Piece])(firstChip:(Int,Int), chipSet:(Int,Int)):Boolean =
    val c1 = firstChip.add(chipSet.multi(0))
    val c2 = firstChip.add(chipSet.multi(1))
    val c3 = firstChip.add(chipSet.multi(2))
    val c4 = firstChip.add(chipSet.multi(3))

    this.cell(c1._1,c1._2).piece == currentPiece &&
      this.cell(c2._1, c2._2).piece == currentPiece &&
      this.cell(c3._1, c3._2).piece == currentPiece &&
      this.cell(c4._1, c4._2).piece == currentPiece


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
