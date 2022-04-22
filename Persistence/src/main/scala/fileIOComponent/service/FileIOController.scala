package fileIOComponent.service

import com.google.inject.{Guice, Inject, Injector}

import java.io.*
import scala.io.Source

object FileIOController {


  def load(): String = {
    fileIOComponent.json.FileIO.load()
  }

  def save(gameAsText: String): Unit = {
    fileIOComponent.json.FileIO.save(gameAsText)
  }

}
