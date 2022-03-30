package tictactoe.presentation

import tictactoe.core.boards.Slot
import tictactoe.core.games.Game
import tictactoe.core.players.{Computer, Human, Player}

object GameFactory {
  def apply(isCrossAi: Boolean, isCircleAi: Boolean): Game = {
    val players = Seq(isCrossAi, isCircleAi)
      .zip(Seq(Slot.X, Slot.O))
      .map { case (isAi, mark) => Player.apply(isAi, mark) }
    new Game(players(0), players(1), ConsoleView)
  }
}
