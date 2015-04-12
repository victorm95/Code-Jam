package victorm

import scala.io.Source
import java.io.PrintWriter

object Main extends App {

  val input = Source.fromFile("input.in")
  val output = new PrintWriter("output.out")

  val lines = input.getLines
  val cases = lines.next.toInt

  for(cas <- 0 until cases) {
    val words = lines.next.split(" ").reverse
    output.print(s"Case #${cas+1}: ")
    for(word <- words) output.print(word + " ")
    output.print("\n")
  }

  input.close
  output.close

}
