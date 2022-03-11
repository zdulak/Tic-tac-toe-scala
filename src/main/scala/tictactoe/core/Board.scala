package tictactoe.core

class Board(val size: Int, slots: IndexedSeq[IndexedSeq[Slot.Value]]) {
  private val _slots = slots
  
  def this(size: Int) = this(size,
    for (_ <- 0 until size) yield for (_ <- 0 until size) yield Slot.Empty)

  def apply(row: Int, col: Int): Slot.Value = _slots(row)(col)

  def mark(row: Int, col: Int, slotValue: Slot.Value): Board =
    new Board(size, _slots.updated(row, _slots(row).updated(col, slotValue)))

  def unmark(row: Int, col: Int): Board = mark(row, col, Slot.Empty)

  def isSlotFull(row: Int, col: Int): Boolean = apply(row, col) != Slot.Empty

  def hasWon(player: Slot.Value): Boolean = rowWon(player) || colWon(player) || diagWon(player)

  private def rowWon(player: Slot.Value): Boolean =
    _slots.exists(rowSlots => rowSlots.forall(slot => slot == player))

  private def colWon(player: Slot.Value): Boolean = {
    (for (col <- 0 until size) yield {
      val column = for (rowSlots <- _slots) yield rowSlots(col)
      column.forall(slot => slot == player)
    }).contains(true)
  }
  private def diagWon(player: Slot.Value): Boolean = {
    val diag1 = Vector.fill(3)(Slot.Empty) == (for (i <- 0 until size) yield apply(i, i))
    val diag2 = Vector.fill(3)(Slot.Empty) == (for (i <- 0 until size) yield apply(size - 1 - i, i))
    diag1 || diag2
  }
}

