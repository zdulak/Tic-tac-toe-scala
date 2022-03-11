package tictactoe.core

class Board(val size: Int, slots: IndexedSeq[IndexedSeq[Slot.Value]]) {
  private val _slots = slots
  
  def this(size: Int) = this(size,
    for (_ <- 0 until size) yield for (_ <- 0 until size) yield Slot.Empty)

  def apply(row: Int, col: Int): Slot.Value = _slots(row)(col)

  def apply(row: Int, col: Int, slot: Slot.Value): Board = {
    val newSlots = _slots.updated(row, _slots(row).updated(col, slot))
    new Board(size, newSlots)
  }
}

