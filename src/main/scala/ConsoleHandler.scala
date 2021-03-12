import scala.annotation.tailrec
import scala.io.StdIn

object ConsoleHandler {
  def functionHandler(line: String): Double => Double = {
    line.trim match {
      case "1" => first
      case "2" => second
      case _ => print("Извините простите вы не так поняли я сейчас объясню простите давайте " +
        "уважать друг друга и дружить\nвыберите, пожалуйста, одну из предложенных фунций")
        first
    }
  }
  def agreeHandler(line: String): Boolean = {
    line.trim.toLowerCase match {
      case "da" | "yes" | "y" | "+" | "true" | "да" => true
      case a if a.toInt > 0 => true
      case _ => false
    }
  }

  private def first(x: Double) = -1.38 * Math.pow(x, 3) - 5.42 * Math.pow(x, 3) + 2.57 * x + 10.95
  private def second(x: Double) = x*x
}
