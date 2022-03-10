package tictactoe.presentation

import scala.io.StdIn._
import java.io.IOException

object View {
  def printMainMenu(): Unit = {
    println("The tic tac toe game")
    println("Choose one options from the list below.\n")
    println("1. New game")
    println("2. About")
    println("3. Exit")
  }

  def printAbout(): Unit ={
    println("This game was made by Damian Zdulski")
    println("Press Enter key to return to the main menu")

    try {
      System.in.read()
    }
    catch {
      case _: IOException =>
    }
  }

  def printNewGameMenu(): Unit = {
    println("Choose one options from the list below.\n")
    println("1. Player vs. player")
    println("2. Player vs. computer")
    println("3. Computer vs player")
    println("4. Computer vs. computer")
    println("5. Return to main menu")
  }
}
