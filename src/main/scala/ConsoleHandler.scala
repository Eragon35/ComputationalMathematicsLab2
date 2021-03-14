import scala.io.StdIn

object ConsoleHandler {
  def functionHandler(line: String): Double => Double = {
    line.trim match {
      case "1" => first
      case "2" => second // TODO: add normal functions
      case "exit" => System.exit(0)
        Math.pow(2, _) // костыль чтобы иметь возможность выйти из программы
      case _ => Console.err.println("Такой функции нет, дам только самую первую")
        first
    }
  }
  def agreeHandler(line: String): Boolean = {
    line.trim.toLowerCase match {
      case "da" | "yes" | "y" | "+" | "true" | "да" => true
      case a => try {
        if (a.toDouble > 0) return true
        } catch {
        case exception: Exception =>
      }; false
      case _ => false
    }
  }
  def accuracyAgreeHandler(line: String): Double = {
    if (agreeHandler(line)) 0.01
    else {
      println("Введите желаемую точность")
      try {
        val accuracy = StdIn.readDouble()
        return accuracy
      } catch {
        case e: Exception => Console.err.println("Ошибка чтения\nточность установлена на значение 0.01")
      }; 0.01
    }
  }

  private def first(x: Double) = -1.38 * Math.pow(x, 3) - 5.42 * Math.pow(x, 2) + 2.57 * x + 10.95
  private def second(x: Double) = Math.cos(x)
}
