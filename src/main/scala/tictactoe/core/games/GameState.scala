package tictactoe.core.games

import tictactoe.core.boards.Slot
import tictactoe.core.traits.Board

sealed trait GameState {
  val board: Board
}

object GameState {
  case class Won(override val board: Board, playerMark: Slot.Value) extends GameState
  case class Tie(override val board: Board) extends GameState
  case class InProgress(override val board: Board, currentPlayer: Slot.Value) extends GameState
}

