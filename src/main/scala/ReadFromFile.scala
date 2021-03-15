import Main._

import scala.io.Source

object ReadFromFile {

  def read(fileName: String): Unit = {
    try {
      FileChecker.check(fileName)
      val source = Source.fromFile(fileName)
      val line = source.getLines().next().split(" ")
      accuracy = line(0).toDouble
      right = line(1).toDouble
      left = line(2).toDouble
      source.close()
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing file\n" + e.getMessage)
        e.printStackTrace()
    }
  }

}
