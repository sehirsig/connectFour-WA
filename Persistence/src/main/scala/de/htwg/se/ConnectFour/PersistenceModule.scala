package de.htwg.se.ConnectFour

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import de.htwg.se.ConnectFour.databaseComponent.DBInterface
import de.htwg.se.ConnectFour.databaseComponent.DAOInterface
import de.htwg.se.ConnectFour.databaseComponent.MongoDB.DAOMongoDBImpl
import de.htwg.se.ConnectFour.databaseComponent.Slick.*
import de.htwg.se.ConnectFour.fileIOComponent.*
import net.codingwell.scalaguice.ScalaModule

class PersistenceModule extends AbstractModule:
  override def configure() =
    bind(classOf[FileIOInterface]).to(classOf[json.FileIO])
    //bind(classOf[FileIOInterface]).to(classOf[xml.FileIO])
    bind(classOf[DBInterface]).to(classOf[DBSlickImpl])
    //bind(classOf[DAOInterface]).to(classOf[DAOSlickGridPlayerImpl])
    bind(classOf[DAOInterface]).to(classOf[DAOMongoDBImpl])
