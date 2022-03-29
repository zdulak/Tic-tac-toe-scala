package tictactoe.core.games

import tictactoe.core.boards.{DefaultBoard, Slot}
import tictactoe.core.players.Player
import tictactoe.core.traits.View

import scala.annotation.tailrec

class Game (playerCross: Player, playerCircle: Player, view: View){
  private val _players = Map(Slot.Cross -> playerCross, Slot.Circle -> playerCircle)

  def run(): Unit = doTurn(GameState.InProgress(new DefaultBoard(3), Slot.Cross))

  @tailrec
  private def doTurn(gameState: GameState): Unit = {
    view.printBoard(gameState.board)
    gameState match {
      case _: GameState.Tie => view.printMsg("It's a tie!")
      case won: GameState.Won => view.printMsg("Player " + won.playerMark + " has won!")
      case inProgress: GameState.InProgress =>
        doTurn(_players(inProgress.currentPlayer).makeMove(inProgress))
    }
  }
}
