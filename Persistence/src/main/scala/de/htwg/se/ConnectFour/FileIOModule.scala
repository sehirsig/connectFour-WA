package de.htwg.se.ConnectFour

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import de.htwg.se.ConnectFour.fileIOComponent.*
import net.codingwell.scalaguice.ScalaModule

class FileIOModule extends AbstractModule:
  override def configure() =
    bind(classOf[FileIOInterface]).to(classOf[json.FileIO])
  //bind(classOf[FileIOInterface]).to(classOf[xml.FileIO])
