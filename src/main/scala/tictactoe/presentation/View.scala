package tictactoe.presentation

import tictactoe.core.Board
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
    //Code below reads from keyboard when the enter key is pressed.
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

  def printBoard(board: Board): Unit = {
    val alphabet = for (i <- 0 until board.size) yield (i + 65).toChar

    println()
    for (i <- 1 to board.size) print("   " + i.toString)
    println("\n")
    for (row <- 0 until board.size) {
      print(alphabet(row) + " ")
      for (col <- 0 until board.size) {
        print(" " + board(row, col).toString + " ")
        if(col < board.size - 1) print("|") else println()
      }
      if (row < board.size - 1) {
        print("  ")
        for (col <- 0 until board.size) {
          print("---")
          if(col !=  board.size - 1) print("+") else println()
        }
      }
    }
  }
}
