package tictactoe.core.boards
import tictactoe.core.traits.Board

class DefaultBoard(slots: IndexedSeq[IndexedSeq[Slot.Value]]) extends Board {
  val size: Int =  slots.length
  private val _slots = slots

  def this(size: Int) = this(for (_ <- 0 until size) yield for (_ <- 0 until size) yield Slot.Empty)

  def apply(row: Int): Seq[Slot.Value] = _slots(row)

  def apply(row: Int, col: Int): Slot.Value = _slots(row)(col)

  def mark(row: Int, col: Int, slotValue: Slot.Value): DefaultBoard =
    new DefaultBoard(_slots.updated(row, _slots(row).updated(col, slotValue)))

  def unmark(row: Int, col: Int): DefaultBoard = mark(row, col, Slot.Empty)

  def isSlotFull(row: Int, col: Int): Boolean = apply(row, col) != Slot.Empty

  def isFull: Boolean = _slots.forall(rowSlots => !rowSlots.contains(Slot.Empty))

  def hasWon(player: Slot.Value): Boolean = rowWon(player, _slots) || colWon(player) || diagWon(player)

  private def rowWon(player: Slot.Value, slots: IndexedSeq[IndexedSeq[Slot.Value]]): Boolean =
    slots.exists(rowSlots => rowSlots.forall(slot => slot == player))

  private def colWon(player: Slot.Value): Boolean = {
    rowWon(player, _slots.transpose)
    //    Alternative solution
    //    (for (col <- 0 until size) yield {
    //      val column = for (rowSlots <- _slots) yield rowSlots(col)
    //      column.forall(slot => slot == player)
    //    }).contains(true)
  }
  private def diagWon(player: Slot.Value): Boolean = {
    // Last character in the name shows direction of a diagonal
    val diag_\ = Vector.fill(3)(player) == (for (i <- 0 until size) yield apply(i, i))
    // For second diagonal I use alternative way of checking the condition
    val diag_/ = (for (i <- 0 until size) yield apply(size - 1 - i, i)).forall(_ == player)
    diag_\ || diag_/
  }
}

