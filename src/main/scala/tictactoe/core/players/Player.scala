package tictactoe.core.players

import tictactoe.core.game.{GameState, InProgress, Tie, Won}
import tictactoe.core.{Board, Slot}

abstract class Player(val playerMark: Slot.Value, val board: Board) {
  def getMove: (Int, Int)
  
  def playerTurn: GameState = {
    val (row, col) = getMove
    val newBoard = board.mark(row, col, playerMark)
    if (newBoard.hasWon(playerMark)) Won(playerMark)
    else if (newBoard.isFull) Tie()
    else InProgress()
  }
}
