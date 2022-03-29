package tictactoe.presentation

import tictactoe.core._
import tictactoe.core.boards.Slot
import tictactoe.core.games.Game
import tictactoe.core.players.Human

object TicTacToe {
  def main(args: Array[String]): Unit = {
    val playerCross = new Human(Slot.Cross, Controller)
    val playerCircle = new Human(Slot.Circle, Controller)
    val game = new Game(playerCross, playerCircle, ConsoleView)
    game.run()
  }
}
