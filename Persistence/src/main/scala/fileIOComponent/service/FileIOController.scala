package fileIOComponent.service

import com.google.inject.{Guice, Inject}
import model.playerComponent.playerBaseImpl.Player
import model.gridComponent.GridInterface

import java.io._
import play.api.libs.json.{JsValue, Json}
import scala.io.Source


object FileIOController {

  def load(): String = {
    val file = scala.io.Source.fromFile("game.json")
    try file.mkString finally file.close()
  }

  def save(gameAsJson: String): Unit = {
    val pw = new PrintWriter(new File("." + File.separator + "game.json"))
    pw.write(gameAsJson)
    pw.close
  }

}
