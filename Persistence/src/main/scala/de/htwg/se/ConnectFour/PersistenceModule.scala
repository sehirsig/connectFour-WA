package de.htwg.se.ConnectFour

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import de.htwg.se.ConnectFour.databaseComponent.DBInterface
import de.htwg.se.ConnectFour.databaseComponent.DAOInterface
import de.htwg.se.ConnectFour.databaseComponent.MongoDB.*
import de.htwg.se.ConnectFour.fileIOComponent.*
import net.codingwell.scalaguice.ScalaModule

/**
 * Persistence Module to choose between different implementations.
 */
class PersistenceModule extends AbstractModule:
  override def configure(): Unit=
    bind(classOf[FileIOInterface]).to(classOf[json.FileIO])
    //bind(classOf[FileIOInterface]).to(classOf[xml.FileIO])
    //bind(classOf[DAOInterface]).to(classOf[DAOSlickGridPlayerImpl])
    bind(classOf[DAOInterface]).to(classOf[DAOMongoDBImpl])
