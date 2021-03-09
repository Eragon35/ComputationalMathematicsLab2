import scala.annotation.tailrec
import scala.io.StdIn

object ConsoleHandler {
  @tailrec
  def functionHandler(line: String): Object = {
    line.trim match {
      case "1" => null
      case _ => print("Извините простите вы не так поняли я сейчас объясню простите давайте " +
        "уважать друг друга и дружить\nвыберите, пожалуйста, одну из предложенных фунций")
        functionHandler(StdIn.readLine())
    }
  }
  def agreeHandler(line: String): Boolean = {
    line.trim.toLowerCase match {
      case "da" | "yes" | "+" | "true" | "да" => true
      case a if a.toInt > 0 => true
      case _ => false
    }
  }

}
