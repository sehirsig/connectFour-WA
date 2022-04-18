package fileIOComponent.service
import com.google.inject.{Guice, Inject}
import fileIOComponent.FileIOInterface
import fileIOComponent.json.FileIO
import model.gridComponent.gridBaseImpl.Grid
import model.playerComponent.playerBaseImpl.Player


case class PersistenceController @Inject ()() {


  def loadLastGame(player1: Player, player2: Player,grid: Grid): Unit = {
    
  }

  def saveLastGame(): Unit = {

  }

}
