package tictactoe.core.traits

import tictactoe.core.Board

trait View {
  def printMainMenu(): Unit
  def printAbout(): Unit
  def printNewGameMenu(): Unit
  def printBoard(board: Board): Unit

}
