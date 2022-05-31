package de.htwg.se.ConnectFour.fileIOComponent.xml

import com.google.inject.Inject
import de.htwg.se.ConnectFour.fileIOComponent.FileIOInterface

import java.io.{File, PrintWriter}
import scala.util.{Failure, Success, Try}
import scala.xml.{NodeSeq, PrettyPrinter}

/**
 * FileIO implementation
 * for exporting the game as XML File
 */
class FileIO @Inject () extends FileIOInterface:

  override def load(): String =
    val file = scala.io.Source.fromFile("game.xml")
    try file.mkString finally file.close()

  override def save(gameAsText: String) =
    val pw = new PrintWriter(new File("." + File.separator + "game.xml"))
    pw.write(gameAsText)
    pw.close
