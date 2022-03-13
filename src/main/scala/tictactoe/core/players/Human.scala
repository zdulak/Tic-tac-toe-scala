package tictactoe.core.players
import tictactoe.core.traits.Controller
import tictactoe.core.boards.{Board, Slot}

class Human(playerMark: Slot.Value, controller: Controller) extends Player(playerMark) {
  override def getMove(board: Board): (Int, Int) = controller.getMove(board, playerMark)
}
