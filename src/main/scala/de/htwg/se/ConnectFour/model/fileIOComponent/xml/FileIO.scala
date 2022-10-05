package de.htwg.se.ConnectFour.model.fileIOComponent.xml

import com.google.inject.Inject
import de.htwg.se.ConnectFour.model.fileIOComponent.FileIOInterface
import de.htwg.se.ConnectFour.model.playerComponent.{PlayerBuilderInterface, PlayerInterface}
import de.htwg.se.ConnectFour.model.gridComponent.{Cell, GridInterface, Piece}

import java.io.{File, PrintWriter}
import scala.util.{Failure, Success, Try}
import scala.xml.{NodeSeq, PrettyPrinter}
import scala.io

/**
 * FileIO implementation
 * for exporting the game as XML File
 */
class FileIO @Inject () extends FileIOInterface:

  override def load(player1:PlayerInterface, player2:PlayerInterface, grid:GridInterface):GridInterface =
    Try(loadMethod(player1, player2, grid)) match
      case Success(v) => v
      case Failure(v) => grid

  def loadMethod(player1:PlayerInterface, player2:PlayerInterface, par_grid: GridInterface):GridInterface =
    val file = scala.xml.XML.loadFile("game.xml")
    val cellNodes = (file \\ "grid" \\ "cell")
    recursiveSetGrid(player1, player2, cellNodes, 0, par_grid)



  def recursiveSetGrid(player1:PlayerInterface, player2:PlayerInterface, cells:NodeSeq, idx:Int, grid:GridInterface):GridInterface =
    if cells.length == idx then
      return grid

    val cell = cells(idx)

    val row: Int = (cell \\ "@row").text.toInt
    val col: Int = (cell \\ "@col").text.toInt
    val value: Int = cell.text.trim.toInt
    val optPiece = value match
      case 1 => Some(Piece(player1))
      case 2 => Some(Piece(player2))
      case _ => None
    recursiveSetGrid(player1, player2, cells, idx + 1, grid.replaceCell(row, col, Cell(optPiece)))

  def gameToXml(par_grid: GridInterface) =
    <game>
      <grid>
        {
        (0 to par_grid.colCount - 1).flatMap(col =>
          (0 to par_grid.rowCount - 1).reverse.map(row => {
            val player = par_grid.cell(row, col).piece match
              case Some(s) => s.player.playerNumber
              case None => -1
            <cell row={ row.toString } col={ col.toString }>
              { player.toString }
            </cell>
          }))
        }
      </grid>
    </game>

  override def save(game: GridInterface) =
    val pw = PrintWriter(File("game.xml"))
    val prettyPrinter = PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(gameToXml(game))
    pw.write(xml)
    pw.close()