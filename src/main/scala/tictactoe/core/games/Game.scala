package tictactoe.core.games

import tictactoe.core.boards.{Board, Slot}
import tictactoe.core.players.Player
import tictactoe.core.traits.View

import scala.annotation.tailrec

class Game (playerCross: Player, playerCircle: Player, view: View){
  private val _players = Map(Slot.Cross -> playerCross, Slot.Circle -> playerCircle)

  def run(): Unit = doTurn(InProgress(new Board(3), Slot.Cross))

  @tailrec
  private def doTurn(gameState: GameState): Unit = {
    view.printBoard(gameState.board)
    gameState match {
      case _: Tie => view.printMsg("It's a tie!")
      case w: Won => view.printMsg("Player " + w.playerMark + " has won!")
      case g: InProgress =>
        doTurn(_players(g.currentPlayer).makeMove(g))
    }
  }
}
