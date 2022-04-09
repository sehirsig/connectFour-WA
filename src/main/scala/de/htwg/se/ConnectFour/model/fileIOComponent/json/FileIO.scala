package de.htwg.se.ConnectFour.model.fileIOComponent.json

import com.google.inject.Inject
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import de.htwg.se.ConnectFour.model.fileIOComponent.FileIOInterface
import de.htwg.se.ConnectFour.model.gridComponent.{Cell, GridInterface, Piece}
import play.api.libs.json.*

import java.io.{File, PrintWriter}
import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
 * FileIO implementation
 * for exporting the game as JSON File
 */
class FileIO @Inject () extends FileIOInterface:

  override def load(controller:ControllerInterface) =
    Try(loadMethod(controller)) match
      case Success(v) => controller.setGrid(v)
      case Failure(v) =>

  def loadMethod(controller: ControllerInterface):GridInterface =
    val source: String = Source.fromFile("game.json").getLines.mkString
    val gameJson: JsValue = Json.parse(source)
    val grid = (gameJson \ "grid")
    val moveCount = (gameJson \ "player" \ "moveCount" \ "value").get.toString().toInt
    val currentPlayer = (gameJson \ "player" \ "currentPlayer").get.toString()
    val player1 = (gameJson \ "player" \ "player1").get.toString()
    val player2 = (gameJson \ "player" \ "player2").get.toString()

    controller.setMoveCount(moveCount)
    controller.addPlayer(player1)
    controller.addPlayer(player2)
    currentPlayer match
      case player1 => controller.setCurrentPlayer(controller.players(0))
      case player2 => controller.setCurrentPlayer(controller.players(1))

    val cells = (grid \ "cells").as[JsArray]
    recursiveSetGrid(controller, cells, 0, controller.getGrid())


  def recursiveSetGrid(controller:ControllerInterface, cells:JsArray, idx:Int, grid:GridInterface):GridInterface =
    if cells.value.length == idx then
      return grid

    val cell = cells.value(idx)

    val row = (cell \ "row").get.as[Int]
    val col = (cell \ "col").get.as[Int]
    val value = (cell \ "value").get.as[Int]
    val optPiece = value match
      case 1 => Some(Piece(controller.players(0)))
      case 2 => Some(Piece(controller.players(1)))
      case _ => None
    recursiveSetGrid(controller, cells, idx + 1, grid.replaceCell(row, col, Cell(optPiece)))

  def gameToJson(controller: ControllerInterface): JsValue =
    Json.obj(
      "player" -> Json.obj(
        "moveCount" -> Json.obj(
          "value"  -> controller.moveCount
        ),
        "currentPlayer" -> Json.obj(
          "name" -> controller.currentPlayer.playerName
        ),
        "player1" -> Json.obj(
          "name" -> controller.players(0).playerName
        ),
        "player2" -> Json.obj(
          "name" -> controller.players(1).playerName
        )
      ),
      "grid" -> Json.obj(
        "cells" -> Json.toJson(
          (0 to controller.getGrid().colCount - 1).flatMap(col =>
            (0 to controller.getGrid().rowCount - 1).reverse.map(row => {
              val player = controller.getGrid().cell(row, col).piece match
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

  override def save(game: ControllerInterface) =
    val pw = PrintWriter(File("game.json"))
    pw.write(Json.prettyPrint(gameToJson(game)))
    pw.close