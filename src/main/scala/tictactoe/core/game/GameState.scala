package tictactoe.core.game

import tictactoe.core.Slot

sealed trait GameState

case class Won(playerMark: Slot.Value) extends GameState
case class Tie() extends GameState
case class InProgress() extends GameState
