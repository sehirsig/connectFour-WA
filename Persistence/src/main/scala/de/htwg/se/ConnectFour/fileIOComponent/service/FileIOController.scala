package de.htwg.se.ConnectFour.fileIOComponent.service

import com.google.inject.{Guice, Inject, Injector}
import de.htwg.se.ConnectFour.fileIOComponent.{FileIOInterface, FileIOModule}

import java.io.*
import scala.io.Source

object FileIOController {

  val injector: Injector = Guice.createInjector(FileIOModule())
  val fileIO = injector.getInstance(classOf[FileIOInterface])

  def load(): String = {
    fileIO.load()
  }

  def save(gameAsText: String): Unit = {
    fileIO.save(gameAsText)
  }

}
