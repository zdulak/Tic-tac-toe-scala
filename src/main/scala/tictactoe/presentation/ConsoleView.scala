package tictactoe.presentation

import tictactoe.core.traits.{Board, View}

import scala.util.Try

object ConsoleView extends  View {
  def printMsg(msg: String): Unit = println(msg)

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
    //Code below reads from a keyboard when the enter key is pressed.
    Try { System.in.read()}

    //Alternative solution
    //    try {
    //      System.in.read()
    //    }
    //    catch {
    //      case _: IOException =>
    //    }
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
//    A=65 in unicode,B,C etc.
    val alphabet = for (i <- 0 until board.size) yield (i + 65).toChar

    println()
    // At the top print:   1   2   3
    for (i <- 1 to board.size) print("   " + i.toString)
    println("\n")
    for (row <- 0 until board.size) {
      // print letter in each row
      print(alphabet(row) + " ")
      for (col <- 0 until board.size) {
        // print: . | . | .
        print(" " + board(row, col).toString + " ")
        if(col < board.size - 1) print("|") else println()
      }
      if (row < board.size - 1) {
        //print space between letter and slots
        print("  ")
        for (col <- 0 until board.size) {
          //separate each row with:---+---+---
          print("---")
          if(col !=  board.size - 1) print("+") else println()
        }
      }
    }
    println()
  }
}