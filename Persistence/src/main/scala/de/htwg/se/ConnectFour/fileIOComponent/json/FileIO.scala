package de.htwg.se.ConnectFour.fileIOComponent.json

import com.google.inject.Inject
import de.htwg.se.ConnectFour.fileIOComponent.FileIOInterface
import play.api.libs.json.*

import java.io.{File, PrintWriter}
import scala.io.Source
import scala.util.{Failure, Success, Try}
import java.io.*

/**
 * FileIO implementation
 * for exporting the game as JSON File
 */
class FileIO @Inject () extends FileIOInterface {

  override def load(): String = {
    val file = scala.io.Source.fromFile("game.json")
    try file.mkString finally file.close()
  }

  override def save(gameAsText: String): Unit = {
    val pw = new PrintWriter(new File("." + File.separator + "game.json"))
    pw.write(gameAsText)
    pw.close
  }
}
/*
  OLD Code (nice resursive functions)

  override def load(grid:GridInterface):GridInterface =
    val player1 = Player("Player 1", 1)
    val player2 = Player("Player 2", 2)
    Try(loadMethod(player1, player2, grid)) match
      case Success(v) => v
      case Failure(v) => grid

  def loadMethod(player1:PlayerInterface, player2:PlayerInterface, par_grid: GridInterface):GridInterface =
    val source: String = Source.fromFile("game.json").getLines.mkString
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

  def gameToJson(par_grid: GridInterface): JsValue =
    Json.obj(
      "grid" -> Json.obj(
        "cells" -> Json.toJson(
          (0 to par_grid.colCount - 1).flatMap(col =>
            (0 to par_grid.rowCount - 1).reverse.map(row => {
              val player = par_grid.cell(row, col).piece match
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

  override def save(game: GridInterface) =
    val pw = PrintWriter(File("game.json"))
    pw.write(Json.prettyPrint(gameToJson(game)))
    pw.close
*/