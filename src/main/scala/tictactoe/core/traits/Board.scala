package tictactoe.core.traits

import tictactoe.core.boards.Slot

trait Board {
  val size: Int

  def apply(row: Int): Seq[Slot.Value]

  def apply(row: Int, col: Int): Slot.Value

  def mark(row: Int, col: Int, slotValue: Slot.Value): Board

  def unmark(row: Int, col: Int): Board

  def isSlotFull(row: Int, col: Int): Boolean

  def isFull: Boolean

  def hasWon(player: Slot.Value): Boolean
}
