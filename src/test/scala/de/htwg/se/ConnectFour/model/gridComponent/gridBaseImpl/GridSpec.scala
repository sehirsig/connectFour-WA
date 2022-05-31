package de.htwg.se.ConnectFour.model.gridComponent.gridBaseImpl

import de.htwg.se.ConnectFour.model.playerComponent.playerBaseImpl.Player
import de.htwg.se.ConnectFour.model.gridComponent.*
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import play.api.libs.json.Json

/**
 * Grid Base Implementation tests.
 */
class GridSpec extends AnyWordSpec with Matchers:

  "A Grid" when {
    val grid = new Grid()
    "initialised" should {
      "be created with 6 rows and 7 initialised with Cell type None" in {
        grid.cell(0, 0) should be(Cell(None))
        grid.cell(1, 1) should be(Cell(None))
        grid.cell(2, 2) should be(Cell(None))
        grid.cell(3, 3) should be(Cell(None))
        grid.cell(4, 4) should be(Cell(None))
        grid.cell(5, 5) should be(Cell(None))
        grid.cell(5, 6) should be(Cell(None))
      }
      "should not have a PlainString yet" in {
        grid.toPlainString should be ("")
      }
      "should have a default toJsonString" in {
        grid.toJsonString(0, "Player1","Player1", "Player2") should include ("\"value\" : 0")
      }
      "should have a default toJson" in {
        Json.prettyPrint(grid.toJson(0, "Player1","Player1", "Player2")) should include ("\"value\" : 0")
      }
    }
    "when not full" should {
      "have a method to replace specific cells" in {
        val replaced = grid.replaceCell(0, 3, Cell(Some(Piece(Player("Your Name", 1)))))
        replaced.cell(0, 3).piece should be(Some(Piece(Player("Your Name", 1))))
      }
      "have a method to put Pieces into the Grid" in {
        val dropped = grid.drop(0, Piece(Player("Your Name", 1)))
        dropped.cell(0, 0).piece should be(Some(Piece(Player("Your Name", 1))))
      }
      "have a method to reset the whole Grid" in {
        grid.reset() should be(new Grid())
      }
    }
    "when full" should {
      "have no new dropped Piece" in {
        var afterFull: GridInterface = new Grid()
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        afterFull = afterFull.drop(0, Piece(Player("Your Name", 1)))
        val newDrop = afterFull.drop(0, Piece(Player("Your Name", 1)))
        newDrop.rows should be(afterFull.rows)
      }
      "should be able to load from a json file" in {
        val json_grid = grid.toJsonString(1, "Player1","Player1", "Player2")
        val p1 = Player("Player1", 1)
        val p2 = Player("Player2", 2)
        grid.jsonToGrid(p1, p2, grid, json_grid) should be (grid)
      }
    }
    "when filled specifically" should {
      "wrong it shouldn't be checked correctly" in {
        var controller: GridInterface = new Grid()
        var player1 = new Player("Player1", 1)
        var player2 = new Player("Player2", 2)
        controller.checkWin(player1) should be(false)
      }
      "all patterns should be checked correctly" in {
        var grid: GridInterface = new Grid()
        var player1 = new Player("Player1", 1)
        var player2 = new Player("Player2", 2)
        grid = grid.replaceCell(0, 0, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(0, 1, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(0, 2, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(0, 3, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(1, 0, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(2, 0, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(3, 0, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(1, 1, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(2, 2, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(3, 3, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(5, 6, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(4, 5, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(3, 4, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(2, 3, Cell(Some(Piece(player1))))

        grid.checkWin(player1) should be(true)
      }
      "any horizontal pattern be checked correctly" in {
        var grid: GridInterface = new Grid()
        var player1 = new Player("Player1", 1)
        var player2 = new Player("Player2", 2)
        grid = grid.replaceCell(0, 0, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(0, 1, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(0, 2, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(0, 3, Cell(Some(Piece(player1))))
        val horizontal = grid.winPattern(Some(Piece(player1)))(grid.rowCount - 1, grid.colCount - 4, (0, 1))
        var bool = false
        horizontal match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be(true)
      }
      "any vertical pattern be checked correctly" in {
        var grid: GridInterface = new Grid()
        var player1 = new Player("Player1", 1)
        var player2 = new Player("Player2", 2)
        grid = grid.replaceCell(0, 0, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(1, 0, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(2, 0, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(3, 0, Cell(Some(Piece(player1))))
        val vertical = grid.winPattern(Some(Piece(player1)))(grid.rowCount - 4, grid.colCount - 1, (1, 0))
        var bool = false
        vertical match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be(true)
      }
      "the bottom left corner be checked correctly ascending diagonally" in {
        var grid: GridInterface = new Grid()
        var player1 = new Player("Player1", 1)
        var player2 = new Player("Player2", 2)
        grid = grid.replaceCell(0, 0, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(1, 1, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(2, 2, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(3, 3, Cell(Some(Piece(player1))))
        val ascDiagonal = grid.winPattern(Some(Piece(player1)))(grid.rowCount - 4, grid.colCount - 4, (1, 1))
        var bool = false
        ascDiagonal match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be(true)
      }

      "the upper right corner be checked correctly ascending diagonally" in {
        var grid: GridInterface = new Grid()
        var player1 = new Player("Player1", 1)
        var player2 = new Player("Player2", 2)
        grid = grid.replaceCell(5, 6, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(4, 5, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(3, 4, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(2, 3, Cell(Some(Piece(player1))))
        val ascDiagonal = grid.winPattern(Some(Piece(player1)))(grid.rowCount - 4, grid.colCount - 4, (1, 1))
        var bool = false
        ascDiagonal match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be(true)
      }
      "the upper left corner be checked correctly descending diagonally if a player has won the game" in {
        var grid: GridInterface = new Grid()
        var player1 = new Player("Player1", 1)
        var player2 = new Player("Player2", 2)
        grid = grid.replaceCell(5, 0, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(4, 1, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(3, 2, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(2, 3, Cell(Some(Piece(player1))))
        val descDiagonal = grid.winPattern(Some(Piece(player1)))(grid.rowCount - 1, grid.colCount - 4, (-1, 1), 3)
        var bool = false
        descDiagonal match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be(true)
      }
      "the bottom right corner be checked correctly descending diagonally if a player has won the game" in {
        var grid: GridInterface = new Grid()
        var player1 = new Player("Player1", 1)
        var player2 = new Player("Player2", 2)
        grid = grid.replaceCell(0, 6, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(1, 5, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(2, 4, Cell(Some(Piece(player1))))
        grid = grid.replaceCell(3, 3, Cell(Some(Piece(player1))))
        val descDiagonal = grid.winPattern(Some(Piece(player1)))(grid.rowCount - 1, grid.colCount - 4, (-1, 1), 3)
        var bool = false
        descDiagonal match {
          case Some(v) => bool = v
          case None => bool = false
        }
        bool should be(true)
      }
    }
  }
