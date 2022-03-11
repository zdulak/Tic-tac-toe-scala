package tictactoe.core.players

import tictactoe.core.games.{GameState, InProgress, Tie, Won}
import tictactoe.core.{Board, Slot}

abstract class Player(val playerMark: Slot.Value) {
  def getMove(board: Board): (Int, Int)

  def makeMove(board: Board): GameState = {
    val (row, col) = getMove(board)
    val newBoard = board.mark(row, col, playerMark)
    if (newBoard.hasWon(playerMark)) Won(playerMark, newBoard)
    else if (newBoard.isFull) Tie(newBoard)
    else InProgress(newBoard)
  }
}
