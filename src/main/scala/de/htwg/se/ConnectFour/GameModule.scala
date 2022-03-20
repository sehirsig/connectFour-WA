package de.htwg.se.ConnectFour

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import de.htwg.se.ConnectFour.controller.Controller
import de.htwg.se.ConnectFour.controller.impl.ControllerImpl
import de.htwg.se.ConnectFour.model.fileio.FileIO
import de.htwg.se.ConnectFour.model.fileio._
import de.htwg.se.ConnectFour.model.grid.Grid
import de.htwg.se.ConnectFour.model.grid.impl.GridImpl
import de.htwg.se.ConnectFour.model.player.PlayerBuilder
import de.htwg.se.ConnectFour.model.player.impl.PlayerBuilderImpl
import net.codingwell.scalaguice.ScalaModule

/**
 * GameModule class
 * here is dependency injection
 * being done for the game components
 */
class GameModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[PlayerBuilder]).to(classOf[PlayerBuilderImpl])
    bind(classOf[Grid]).to(classOf[GridImpl])
    bind(classOf[FileIO]).to(classOf[json.FileIOImpl])
    //bind(classOf[FileIO]).to(classOf[xml.FileIOImpl])
    bind(classOf[Controller]).to(classOf[ControllerImpl])
  }
}
