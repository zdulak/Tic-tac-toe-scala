package tictactoe.presentation

import tictactoe.core.boards.{DefaultBoard, Slot}
import tictactoe.core.games.GameState

object Menu {
  def mainMenu(): Unit =
    menu(List(newGameMenu, aboutMenu, Controller.exit), ConsoleView.printMainMenu)

  def newGameMenu(): Unit = {
    val newGame = GameState.InProgress(new DefaultBoard(3), Slot.X)
    menu(List(
      () => GameFactory(isCrossAi = false, isCircleAi = false).run(newGame),
      () => GameFactory(isCrossAi = false, isCircleAi = true).run(newGame),
      () => GameFactory(isCrossAi = true, isCircleAi = false).run(newGame),
      () => GameFactory(isCrossAi = true, isCircleAi = true).run(newGame),
      mainMenu), ConsoleView.printNewGameMenu)
    mainMenu()
  }

  def aboutMenu(): Unit = {
    ConsoleView.printAbout()
    mainMenu()
  }

  private def menu(options: List[() => Unit], message: () => Unit): Unit = {
    val choice = Controller.getMenuChoice(1, options.size, message)
    options(choice)()
  }
}
