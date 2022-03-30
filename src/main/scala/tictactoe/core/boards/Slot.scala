package tictactoe.core.boards

import scala.language.implicitConversions

object Slot extends Enumeration {
  protected case class SlotVal(name: String) extends super.Val(name) {
    def opposite: SlotVal = this match {
      case O => X
      case X => O
      case _ => Empty
    }
  }

  implicit def valueToSlotVal(x: Value): SlotVal = x.asInstanceOf[SlotVal]

  val O: SlotVal = SlotVal("O")
  val X: SlotVal = SlotVal("X")
  val Empty: SlotVal = SlotVal(".")
}
