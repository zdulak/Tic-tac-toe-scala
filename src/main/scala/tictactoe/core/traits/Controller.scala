package tictactoe.core.traits

import tictactoe.core.{Board, Slot}

trait Controller {
  def exit(): Nothing
  def getMove(board: Board, playerMark: Slot.Value): (Int, Int)
}
