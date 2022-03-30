package tictactoe.core.players
import tictactoe.core.boards.Slot
import tictactoe.core.traits.{Board, Controller}

case class Human(override val playerMark: Slot.Value, controller: Controller) extends Player(playerMark) {
  override def getMove(board: Board): (Int, Int) = controller.getMove(board, playerMark)
}
