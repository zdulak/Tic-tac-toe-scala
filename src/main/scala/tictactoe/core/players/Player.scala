package tictactoe.core.players

import tictactoe.core.boards.Slot
import tictactoe.core.games.GameState
import tictactoe.core.traits.Board

abstract class Player(val playerMark: Slot.Value) {
  def getMove(board: Board): (Int, Int)

  def makeMove(gameState: GameState.InProgress): GameState = {
    val (row, col) = getMove(gameState.board)
    val newBoard = gameState.board.mark(row, col, playerMark)
    if (newBoard.hasWon(playerMark)) GameState.Won(newBoard, playerMark)
    else if (newBoard.isFull) GameState.Tie(newBoard)
    else GameState.InProgress(newBoard, gameState.currentPlayer.opposite)
  }
}
