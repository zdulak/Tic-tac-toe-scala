package tictactoe.core.traits

trait View {
  def printMsg(msg: String): Unit
  def printMainMenu(): Unit
  def printAbout(): Unit
  def printNewGameMenu(): Unit
  def printBoard(board: Board): Unit

}
