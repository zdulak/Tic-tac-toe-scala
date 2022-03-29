package tictactoe.presentation

import tictactoe.core.boards.Slot
import tictactoe.core.games.Game
import tictactoe.core.players.{Computer, Human}

object GameFactory {
  def apply(isCrossAi: Boolean, isCircleAi: Boolean): Game = {
    val players = Seq(isCrossAi, isCircleAi)
      .zip(Seq(Slot.Cross, Slot.Circle))
      .map { case (isAi, playerMark) => if (isAi) new Computer(playerMark) else new Human(playerMark, Controller)}
    new Game(players(0), players(1), ConsoleView)
  }
}
