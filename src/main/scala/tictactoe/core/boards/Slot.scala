package tictactoe.core.boards

object Slot extends Enumeration {
  protected case class SlotVal(name: String) extends super.Val(name) {
    def opposite: SlotVal = this match {
      case Circle => Cross
      case Cross => Circle
      case _ => Empty
    }
  }

  implicit def valueToSlotVal(x: Value): SlotVal = x.asInstanceOf[SlotVal]

  val Circle: SlotVal = SlotVal("O")
  val Cross: SlotVal = SlotVal("X")
  val Empty: SlotVal = SlotVal(".")
}
