package de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl

import com.google.inject.Inject
import de.htwg.se.ConnectFour.model.gridComponent.{Cell, GridInterface, Piece}
import de.htwg.se.ConnectFour.model.playerComponent.PlayerInterface
import netscape.javascript.JSObject
import play.api.libs.json.{JsArray, JsValue, Json}

import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
 * Game grid implementation
 */
case class Grid(rows: Vector[Vector[Cell]]) extends GridInterface:

  @Inject()
  def this() = this(Vector.tabulate(6, 7) { (rowCount, col) => Cell(None) })

  override val colCount = 7
  override val rowCount = 6

  override def cell(row: Int, col: Int): Cell = rows(row)(col)

  override def replaceCell(row: Int, col: Int, cell: Cell): Grid = copy(rows.updated(row, rows(row).updated(col, cell)))

  override def drop(column: Int, piece: Piece): Grid =
    val idx = this.rows.indexWhere(row => !row(column).isSet)
    if idx > -1 then
      return this.replaceCell(idx, column, Cell(Some(piece)))
    this

  override def reset(): Grid =
    new Grid()

  override def checkWin(currentPlayer:PlayerInterface):Boolean =
    Try(checkWinTry(currentPlayer)) match
      case Success(v) => v
      case Failure(_) => false


  def checkWinTry(currentPlayer:PlayerInterface):Boolean =
    val playerPiece = Some(Piece(currentPlayer))

    val horizontal = winPattern(playerPiece)(rowCount - 1,colCount - 4,(0,1))
    val vertical = winPattern(playerPiece)(rowCount - 4,colCount - 1,(1,0))
    val ascendingDiagonal = winPattern(playerPiece)(rowCount - 4,colCount - 4,(1,1))
    val descendingDiagonal = winPattern(playerPiece)(rowCount - 1,colCount - 4,(-1,1), 3)
    val checkList:List[Option[Boolean]] = List(horizontal,vertical,ascendingDiagonal,descendingDiagonal)
    //Check ob es einen Win gab
    checkList.filterNot(_.isEmpty).contains(Some(true))

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
    if (max < idx) || (min > idx) then
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
    (0 to 3).map(x => {
      val c = firstChip.add(chipSet.multi(x))
      this.cell(c._1, c._2).piece == currentPiece
    }).forall(_ == true)

  def drawString:String =
    val builder = new StringBuilder
    this.rows.reverse.map(row => {row.map(col => builder.append(col)); builder.append("\n")})
    builder.toString()

  def gameToJson: JsValue =
    Json.obj(
      "grid" -> Json.obj(
        "cells" -> Json.toJson(
          (0 to this.colCount - 1).flatMap(col =>
            (0 to this.rowCount - 1).reverse.map(row => {
              val player = this.cell(row, col).piece match
                case Some(s) => s.player.playerNumber
                case None => -1
              Json.obj(
                "row" -> row,
                "col" -> col,
                "value" -> player
              )
            }))
        )
      )
    )

  override def toJsonString: String =
    Json.prettyPrint(gameToJson)

  override def toJson: JsValue =
    gameToJson

  override def jsonToGrid(player1:PlayerInterface, player2:PlayerInterface, par_grid: GridInterface, source:String): GridInterface =
    val gameJson: JsValue = Json.parse(source)
    val grid = (gameJson \ "grid")

    val cells = (grid \ "cells").as[JsArray]
    recursiveSetGrid(player1, player2, cells, 0, par_grid)


  def recursiveSetGrid(player1:PlayerInterface, player2:PlayerInterface, cells:JsArray, idx:Int, grid:GridInterface):GridInterface =
    if cells.value.length == idx then
      return grid

    val cell = cells.value(idx)

    val row = (cell \ "row").get.as[Int]
    val col = (cell \ "col").get.as[Int]
    val value = (cell \ "value").get.as[Int]
    val optPiece = value match
      case 1 => Some(Piece(player1))
      case 2 => Some(Piece(player2))
      case _ => None
    recursiveSetGrid(player1, player2, cells, idx + 1, grid.replaceCell(row, col, Cell(optPiece)))

  def drawPlainString:String =
    val builder = new StringBuilder
    this.rows.reverse.map(row => {row.map(col => builder.append(col.toPlainString)); builder.append("\n")})
    builder.toString()

  override def toPlainString: String =
    print(drawPlainString);
    this.rows.map(row => row.map(col => if col.isSet then return drawPlainString ))
    ""

  override def toString: String =
    this.rows.map(row => row.map(col => if col.isSet then return drawString ))
    ""
