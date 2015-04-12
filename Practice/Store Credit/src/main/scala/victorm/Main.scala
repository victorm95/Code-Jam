import scala.io.Source
import java.io.PrintWriter

object Main extends App {

  val input = Source.fromFile("input.in")
  val output = new PrintWriter("output.out")
  val lines = input.getLines

  val cases = lines.next.toInt

  for(cas <- 0 until cases) {
    val credit = lines.next.toInt
    val length = lines.next.toInt
    val prices = lines.next.split(" ").map(Integer.parseInt)

    val result = for {
      x <- 0 until length
      y <- 0 until length if((prices(x)+prices(y)) == credit && x!=y)
    } yield (x+1, y+1)

    output.println(s"Case #${cas+1}: ${result(0)._1} ${result(0)._2}")

  }

  input.close
  output.close
}
