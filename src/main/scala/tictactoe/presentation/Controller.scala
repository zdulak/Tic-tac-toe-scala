package tictactoe.presentation

import tictactoe.core.boards.{Board, Slot}
import tictactoe.core.traits.Controller
import scala.annotation.tailrec
import scala.io.StdIn.readLine

object Controller extends  Controller {

  def exit(): Nothing = {
    println("Goodbye!")
    sys.exit()
  }

  @tailrec
  def getMove(board: Board, playerMark: Slot.Value): (Int, Int) = {
//  a=97 in unicode, b=98, etc.
    lazy val translationTable = (for (i <- 0 until board.size) yield ((97 + i).toChar, i)).toMap
    val position =
      readLine("Player " + playerMark + ", please enter the coordinates or write exit: \n").toLowerCase
    if (position == "exit") exit()
    if (position.length == 2 && position(0).isLetter && position(1).isDigit) {
      val row = translationTable.get(position(0)) match {
        case Some(value) => value
        // If letter is not in the translationTable, return number which doesn't satisfy the condition below,
        // i.e., bigger or equal board.size
        case None => board.size
      }
      // Without toString method, the ASCII code of the number is generated
      val col = position(1).toString.toInt - 1
      if ((0 until board.size).contains(row) && (0 until board.size).contains(col)) {
        if (board.isSlotFull(row,col)) {
            println("Slot is occupied.")
            getMove(board, playerMark)
          }
        else {
          // return value
          (row, col)
        }
      }
      else {
        println("Invalid  coordinates")
        getMove(board, playerMark)
      }
    }
    else {
      println("Invalid  input")
      getMove(board, playerMark)
    }
  }
}
