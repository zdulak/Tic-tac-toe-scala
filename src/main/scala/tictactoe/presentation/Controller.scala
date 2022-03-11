package tictactoe.presentation

import tictactoe.core.{Board, Slot}

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object Controller {

  def exit(): Nothing = {
    println("Goodbye!")
    sys.exit()
  }

  @tailrec
  def getHumanMove(board: Board, playerMark: Slot.Value): (Int, Int) = {
//  a=97 in unicode, b=98, etc.
    lazy val translationTable = (for (i <- 0 until board.size) yield ((97 + i).toChar, i)).toMap
    val position =
      readLine("Player " + playerMark + ", please enter the coordinates or write exit:").toLowerCase
    if (position == "exit") exit()
    if (position.length == 2 && position(0).isLetter && position(1).isDigit) {
      val row = translationTable(position(0))
      val col = position(1).toInt - 1
      if ((0 until board.size).contains(row) && (0 until board.size).contains(col)) {
        if (board.isSlotFull(row,col)) {
            println("Slot is occupied.")
            getHumanMove(board, playerMark)
          }
        else (row, col)
      }
      else {
        println("Invalid  coordinates")
        getHumanMove(board, playerMark)
      }
    }
    else {
      println("Invalid  input")
      getHumanMove(board, playerMark)
    }
  }
}
