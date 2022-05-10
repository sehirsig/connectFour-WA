package de.htwg.se.ConnectFour.controller.controllerComponent.controllerBaseImpl

import com.google.inject.{Guice, Inject, Key}
import de.htwg.se.ConnectFour.ConnectFourModule
import de.htwg.se.ConnectFour.controller.controllerComponent.ControllerInterface
import akka.http.scaladsl.server.Directives.{complete, concat, get, path}
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpMethods, HttpRequest, HttpResponse, StatusCode}
import akka.http.scaladsl.server.{ExceptionHandler, Route}
import akka.http.scaladsl.unmarshalling.Unmarshal
import de.htwg.se.ConnectFour.model.gridComponent.{GridInterface, Piece}
import de.htwg.se.ConnectFour.model.playerComponent.{PlayerBuilderInterface, PlayerInterface}
import de.htwg.se.ConnectFour.util.UndoManager
import play.api.libs.json.{JsArray, JsValue, Json}

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}


/**
 *  Controller implementation
 */
class Controller @Inject ()(var grid:GridInterface, val playerBuilder:PlayerBuilderInterface) extends ControllerInterface:
  val injector = Guice.createInjector(ConnectFourModule())


  val fileIOIP = sys.env.getOrElse("FILEIO_SERVICE_HOST", "localhost").toString
  val fileIOPort = sys.env.getOrElse("FILEIO_SERVICE_PORT", 8081).toString.toInt

  val fileIOURI = "http://" + fileIOIP + ":" + fileIOPort + "/fileio"
  val databaseURI = "http://" + fileIOIP + ":" + fileIOPort + "/db"

  var players: Vector[PlayerInterface] = Vector.empty
  var moveCount = 0
  var currentPlayer:PlayerInterface = _
  val maxPlayers = 2
  override val undoManager: UndoManager = new UndoManager

  override def createGrid() =
    reset()
    notifyObservers

  override def addPlayer(name:String) =
    if players.size == 0 then
      players = Vector.empty
      implicit val system = ActorSystem(Behaviors.empty, "SingleRequest")
      implicit val executionContext = system.executionContext
      val responseFuture: Future[HttpResponse] = Http().singleRequest(HttpRequest(method = HttpMethods.GET, uri = databaseURI + "/deleteall"))
      responseFuture
        .onComplete {
          case Failure(_) => println(responseFuture);buildPlayer(name,1)
          case Success(value) => Unmarshal(value.entity).to[String].onComplete {
            case Failure(_) => sys.error("Failed unmarshalling");buildPlayer(name,1)
            case Success(value) => {
              println("Response: " + value)
              buildPlayer(name,1)
            }
          }
        }
    else
      buildPlayer(name,2)

  def buildPlayer(name:String, number:Int) =
    if !(number == players.length) && (number == players.length + 1) then
      val player = playerBuilder.createPlayer(name,number)
      players = players.appended(player)

      implicit val system = ActorSystem(Behaviors.empty, "SingleRequest")
      implicit val executionContext = system.executionContext
      val responseFuture: Future[HttpResponse] = Http().singleRequest(HttpRequest(method = HttpMethods.GET, uri = databaseURI + "/addplayer/" + number + "/" + name.replace(" ", "_")))
      responseFuture
        .onComplete {
          case Failure(_) => println(responseFuture)
          case Success(value) => Unmarshal(value.entity).to[String].onComplete {
            case Failure(_) => sys.error("Failed unmarshalling")
            case Success(value) => {
              println("Response: " + value)
            }
          }
        }

  override def whoseTurnIsIt() =
    currentPlayer = if moveCount % 2 == 0 then players(0) else players(1)
    notifyObservers

  override def checkWin():Boolean =
    grid.checkWin(currentPlayer)

  override def drop(col:String) =
    whoseTurnIsIt()
    var validCol = 0
    if col.toInt <= 6 then
      validCol = col.toInt
    undoManager.doStep(SetCommand.SetCommand(validCol, Piece(currentPlayer),this));
    moveCount += 1
    notifyObservers

  override def undoDrop() =
    undoManager.undoStep
    moveCount -= 1
    notifyObservers

  override def redoDrop() =
    undoManager.redoStep
    moveCount += 1
    notifyObservers

  override def saveGame() =
    this.saveDB
    //FileIO.save(this.grid)
    implicit val system = ActorSystem(Behaviors.empty, "SingleRequest")

    implicit val executionContext = system.executionContext

    val responseFuture: Future[HttpResponse] = Http().singleRequest(HttpRequest(
      method = HttpMethods.POST,
      uri = fileIOURI + "/save",
      entity = gridToJsonString()
    ))
    responseFuture
      .onComplete {
        case Failure(_) => println(responseFuture)
        case Success(value) => Unmarshal(value.entity).to[String].onComplete {
          case Failure(_) => sys.error("Failed unmarshalling")
          case Success(value) => {
            println("Response: " + value)
          }
        }
      }
    notifyObservers

  override def loadGame() =
    //this.grid = FileIO.load(this.players(0), this.players(1), this.grid)
    implicit val system = ActorSystem(Behaviors.empty, "SingleRequest")

    implicit val executionContext = system.executionContext

    val responseFuture: Future[HttpResponse] = Http().singleRequest(HttpRequest(method = HttpMethods.GET, uri = fileIOURI + "/load"))

    responseFuture
      .onComplete {
        case Failure(_) => sys.error("Failed getting Json")
        case Success(value) => {
          Unmarshal(value.entity).to[String].onComplete {
            case Failure(_) => sys.error("Failed unmarshalling")
            case Success(value) => {
              val gameJson: JsValue = Json.parse(value)
              val moveCount = (gameJson \ "player" \ "moveCount" \ "value").get.toString().toInt
              val currentPlayer = (gameJson \ "player" \ "currentPlayer").get.toString()
              val player1 = (gameJson \ "player" \ "player1" \ "name").get.toString()
              val player2 = (gameJson \ "player" \ "player2" \ "name").get.toString()
              setMoveCount(moveCount)
              addPlayer(player1)
              addPlayer(player2)
              currentPlayer match
                case player1 => setCurrentPlayer(players(0))
                case player2 => setCurrentPlayer(players(1))

              val loadedGame = this.grid.jsonToGridM(players(0), players(1), this.grid, value)
              this.grid = loadedGame
              notifyObservers
            }
          }
        }
      }
    notifyObservers

  def saveDB =
    implicit val system = ActorSystem(Behaviors.empty, "SingleRequest")
    implicit val executionContext = system.executionContext

    val responseFuture: Future[HttpResponse] = Http().singleRequest(HttpRequest(
      method = HttpMethods.POST,
      uri = databaseURI + "/save",
      entity = gridToJsonString()
    ))
    responseFuture
      .onComplete {
        case Failure(_) => println(responseFuture)
        case Success(value) => Unmarshal(value.entity).to[String].onComplete {
          case Failure(_) => sys.error("Failed unmarshalling")
          case Success(value) => {
            println("Response: " + value)
          }
        }
      }
    notifyObservers

  override def reset() =
    grid = grid.reset()
    notifyObservers

  override def gridToJsonString(): String =
    this.grid.toJsonString(this.moveCount, this.currentPlayer.playerName, this.players(0).playerName, this.players(1).playerName)

  override def gridToString(): String = this.grid.toString
  override def getGrid(): GridInterface = this.grid
  override def getPlayers(): Vector[PlayerInterface] = this.players
  override def getCurrentPlayer(): PlayerInterface = this.currentPlayer
  override def getMoveCount: Int = this.moveCount
  override def setGrid(grid: GridInterface) = this.grid = grid;notifyObservers
  override def setCurrentPlayer(currentPlayer: PlayerInterface) = this.currentPlayer = currentPlayer;notifyObservers
  override def setMoveCount(moveCount:Int) = this.moveCount = moveCount;notifyObservers
