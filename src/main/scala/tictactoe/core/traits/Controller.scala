package tictactoe.core.traits

import tictactoe.core.{Board, Slot}

trait Controller {
  def exit(): Nothing
  def getHumanMove(board: Board, playerMark: Slot.Value): (Int, Int)
}
