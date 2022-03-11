package tictactoe.core.games

import tictactoe.core.Board
import tictactoe.core.players.Player
import tictactoe.core.traits.View
import scala.annotation.tailrec

class Game (playerCross: Player, playerCircle: Player, view: View){
  private val _players = Vector(playerCross, playerCircle)

  def run(): Unit = doTurn(InProgress(new Board(3)), 0)

  @tailrec
  private def doTurn(gameState: GameState, playerIndex: Int): Unit = {
    view.printBoard(gameState.board)
    gameState match {
      case _: Tie => println("It's a tie!")
      case w: Won => println("Player" + w.playerMark + " has won!")
      case _: InProgress =>
        doTurn(_players(playerIndex).makeMove(gameState.board), (playerIndex + 1) % 2)
    }
  }
}
