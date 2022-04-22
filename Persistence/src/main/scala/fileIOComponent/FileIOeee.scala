package fileIOComponent

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule
import fileIOComponent.FileIOInterface
import fileIOComponent.json.FileIO

class FileIOeee extends AbstractModule:
  override def configure() =
    bind(classOf[FileIOInterface]).to(classOf[FileIO])


