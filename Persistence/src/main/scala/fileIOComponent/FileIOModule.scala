package fileIOComponent

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule
import fileIOComponent.FileIOInterface
import fileIOComponent.*
//import fileIOComponent.xml.FileIO

class FileIOModule extends AbstractModule:
  override def configure() =
    bind(classOf[FileIOInterface]).to(classOf[json.FileIO])
    //bind(classOf[FileIOInterface]).to(classOf[xml.FileIO])


