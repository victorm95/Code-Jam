package victorm

import scala.io.Source
import java.io.PrintWriter

object Main extends App {

  val words = Map('a' -> 2, 'b' -> 22, 'c' -> 222,
                  'd' -> 3, 'e' -> 33, 'f' -> 333,
                  'g' -> 4, 'h' -> 44, 'i' -> 444,
                  'j' -> 5, 'k' -> 55, 'l' -> 555,
                  'm' -> 6, 'n' -> 66, 'o' -> 666,
                  'p' -> 7, 'q' -> 77, 'r' -> 777, 's' -> 7777,
                  't' -> 8, 'u' -> 88, 'v' -> 888,
                  'w' -> 9, 'x' -> 99, 'y' -> 999, 'z' -> 9999,
                  ' ' -> 0)

  val input = Source.fromFile("input.in")
  val output = new PrintWriter("output.out")
  val lines = input.getLines

  val cases = lines.next.toInt

  for(cas <- 0 until cases) {
    
    val text = lines.next
    output.print(s"Case #${cas+1}: ")

    for(i <- 0 until text.length) {
      output.print(words(text(i)))
      if(i < text.length-1) {
        val j = i+1
        if((words(text(i))%10) == (words(text(j))%10)) output.print(" ")
        else if(text(i) == text(j)) output.print(" ")
      }
    }
    output.print("\n")

  }

  input.close
  output.close

}
