package tictactoe.core.traits

import tictactoe.core.boards.Slot

trait Controller {
  def exit(): Nothing
  def getMove(board: Board, playerMark: Slot.Value): (Int, Int)
  def getMenuChoice(lowerBound: Int, upperBound: Int, message: () => Unit): Int
}
