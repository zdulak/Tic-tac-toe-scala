package tictactoe.core.players
import tictactoe.core.{Board, Slot}

class Human(playerMark: Slot.Value, board: Board) extends Player(playerMark, board) {
  override def getMove: (Int, Int) = ???
}
