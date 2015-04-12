package victorm 

import scala.collection.mutable.Set
import scala.io.Source
import java.io.PrintWriter

class Paths {
  var routes = Set[List[String]]()
  var creates = 0

  def add(path: List[String]): Unit = {
    if(!path.isEmpty) {
      routes += path
      add(path.init)
    }
  }
  def create(path: List[String]): Unit = {
    if(!path.isEmpty) {
      if(!routes(path)) {
        creates = creates+1
        routes += path
        create(path.init)
      } 
    }
  }
}

object Solution extends App {
  
  val input = Source.fromFile("input.in")
  val output = new PrintWriter("output.out")
  val lines = input.getLines
 
  val cases = lines.next.toInt
  for(cas <- 0 until cases) {
    val pathCount = lines.next.split(" ").toList.map(Integer.parseInt)
    val paths = new Paths()
    // For Created
    for(i <- 0 until pathCount(0)) {
      paths.add(lines.next.split("/").toList.tail)
    }
    // For need Created
    for(i <- 0 until pathCount(1)) {
      paths.create(lines.next.split("/").toList.tail)
    }
    output.println(s"Case #${cas+1}: ${paths.creates}")
  }

  input.close
  output.close

}
