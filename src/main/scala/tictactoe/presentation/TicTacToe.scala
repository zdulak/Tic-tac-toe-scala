package tictactoe.presentation

import tictactoe.core.boards.{DefaultBoard, Slot}
import tictactoe.core.games.{Game, GameState}
import tictactoe.core.players.Human
import scala.annotation.tailrec

object TicTacToe {
  @tailrec
  def main(args: Array[String]): Unit = {
    val playerCross = new Human(Slot.Cross, Controller)
    val playerCircle = new Human(Slot.Circle, Controller)
    val game = new Game(playerCross, playerCircle, ConsoleView)
    game.run(GameState.InProgress(new DefaultBoard(3), Slot.Cross))
    main(args)
  }
}
