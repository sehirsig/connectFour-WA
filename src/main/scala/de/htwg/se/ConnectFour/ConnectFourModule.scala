package de.htwg.se.ConnectFour

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import de.htwg.se.ConnectFour.controller.controllerComponent.controllerBaseImpl.Controller
//import fileIOComponent.FileIOInterface
//import fileIOComponent.*
import model.gridComponent.GridInterface
import model.gridComponent.gridBaseImpl.Grid
import model.playerComponent.PlayerBuilderInterface
import model.playerComponent.playerBuilderBaseImpl.PlayerBuilder
import model.playerComponent.PlayerInterface
import model.playerComponent.playerBaseImpl.Player
import net.codingwell.scalaguice.ScalaModule

/**
 * GameModule class
 * here is dependency injection
 * being done for the game components
 */
class ConnectFourModule extends AbstractModule:
  override def configure() =
    bindConstant().annotatedWith(Names.named("Dummy")).to("Dummy")
    bindConstant().annotatedWith(Names.named("Eins")).to(1)

    bind(classOf[PlayerInterface]).to(classOf[Player])
    bind(classOf[PlayerBuilderInterface]).to(classOf[PlayerBuilder])
    bind(classOf[GridInterface]).to(classOf[Grid])
    //bind(classOf[FileIOInterface]).to(classOf[json.FileIO])
    //bind(classOf[FileIO]).to(classOf[xml.FileIOImpl])
    bind(classOf[ControllerInterface]).to(classOf[Controller])