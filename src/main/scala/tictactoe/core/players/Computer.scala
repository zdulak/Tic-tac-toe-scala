package tictactoe.core.players

import tictactoe.core.boards.Slot
import tictactoe.core.traits.Board
import scala.util.Random

class Computer(playerMark: Slot.Value) extends Player(playerMark) {
  override def getMove(board: Board): (Int, Int) = {
    val (row, col) = (Random.nextInt(board.size), Random.nextInt(board.size))
    if (board.isSlotFull(row, col)) getMove(board) else {
      Thread.sleep(300)
      (row, col)
    }
  }
}
