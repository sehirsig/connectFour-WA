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
class FileIO @Inject () extends FileIOInterface:

  override def load(): String =
    val file = scala.io.Source.fromFile("game.json")
    try file.mkString finally file.close()

  override def save(gameAsText: String) =
    val pw = new PrintWriter(new File("." + File.separator + "game.json"))
    pw.write(gameAsText)
    pw.close
