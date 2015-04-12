package victorm 

import scala.io.Source
import java.io.PrintWriter

object Solution extends App {

  val input = Source.fromFile("input.in")
  val output = new PrintWriter("output.out")
  val lines = input.getLines

  val cases = lines.next.toInt

  for(cas <- 1 to cases) {
    val line = lines.next
    val max = line.split(" ")(0).toInt
    val data = line.split(" ")(1)
    var friends = 0
    var handClap = 0
    
    for(level <- 0 to max) {
      val people = data(level).toString.toInt
      if(level > handClap) {
        val need: Int = (level - handClap)
        handClap += need
        friends += need
      }
      handClap += people
    }

    output.println(s"Case #$cas: $friends")
  }  

  input.close
  output.close

}
