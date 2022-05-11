package de.htwg.se.ConnectFour

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import de.htwg.se.ConnectFour.databaseComponent.DaoInterface
import de.htwg.se.ConnectFour.databaseComponent.DAO
import de.htwg.se.ConnectFour.databaseComponent.Slick.*
import de.htwg.se.ConnectFour.fileIOComponent.*
import net.codingwell.scalaguice.ScalaModule

class PersistenceModule extends AbstractModule:
  override def configure() =
    bind(classOf[FileIOInterface]).to(classOf[json.FileIO])
  //bind(classOf[FileIOInterface]).to(classOf[xml.FileIO])
    bind(classOf[DaoInterface]).to(classOf[DaoSlick])
    bind(classOf[DAO]).to(classOf[DAOSlickImpl2])
