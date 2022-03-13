package tictactoe.core.players

import tictactoe.core.games.{GameState, InProgress, Tie, Won}
import tictactoe.core.boards.{Board, Slot}

abstract class Player(val playerMark: Slot.Value) {
  def getMove(board: Board): (Int, Int)

  def makeMove(gameState: InProgress): GameState = {
    val (row, col) = getMove(gameState.board)
    val newBoard = gameState.board.mark(row, col, playerMark)
    if (newBoard.hasWon(playerMark)) Won(newBoard, playerMark)
    else if (newBoard.isFull) Tie(newBoard)
    else InProgress(newBoard, gameState.currentPlayer.opposite)
  }
}
