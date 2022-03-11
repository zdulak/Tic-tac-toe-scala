package tictactoe.core.players
import tictactoe.core.traits.Controller
import tictactoe.core.{Board, Slot}

class Human(playerMark: Slot.Value, board: Board, controller: Controller) extends Player(playerMark, board) {
  override def getMove: (Int, Int) = controller.getMove(board, playerMark)
}
