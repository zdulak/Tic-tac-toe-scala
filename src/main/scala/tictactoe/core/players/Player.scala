package tictactoe.core.players

import tictactoe.core.game.GameState
import tictactoe.core.{Board, Slot}

abstract class Player(val playerMark: Slot.Value, val board: Board) {
  def getMove: (Int, Int)
  def playerTurn: GameState = {

  }
}
