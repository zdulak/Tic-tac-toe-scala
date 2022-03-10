package tictactoe.core

class Board(val size: Int) {
  private val _board = for (_ <- 0 until size) yield {
    for (_ <- 0 until size) yield Slot.Empty
  }
}
