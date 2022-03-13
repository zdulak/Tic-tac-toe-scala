package tictactoe.core.games

import tictactoe.core.boards.Slot
import tictactoe.core.boards.{Board, Slot}

sealed trait GameState {
  val board: Board
}

case class Won(playerMark: Slot.Value, override val board: Board) extends GameState
case class Tie(override val board: Board) extends GameState
case class InProgress(override val board: Board, playerIndex: Int) extends GameState
