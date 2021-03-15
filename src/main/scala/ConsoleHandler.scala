import scala.io.StdIn

object ConsoleHandler {
  def functionHandler(line: String): (Double => Double, Double => Double) = {
    line.trim.toLowerCase match {
      case "1" => (first, firstDerivative)
      case "2" => (second, secondDerivative) // TODO: add normal functions
      case "exit" | "e" | "no" | "n" => System.exit(0)
        (Math.pow(2, _), Math.pow(2, _)) // костыль чтобы иметь возможность выйти из программы
      case _ => Console.err.println("Такой функции нет, установлена первая функция")
        (first, firstDerivative)
    }
  }
  private def first(x: Double): Double = -1.38 * Math.pow(x, 3) - 5.42 * Math.pow(x, 2) + 2.57 * x + 10.95
  private def firstDerivative(x: Double): Double = -4.14 * Math.pow(x, 2) -10.84 * x + 2.57
  private def second(x: Double): Double = Math.cos(x)
  private def secondDerivative(x: Double) = -Math.sin(x)

  def agreeHandler(line: String): Boolean = {
    line.trim.toLowerCase match {
      case "da" | "yes" | "y" | "+" | "true" | "да" => true
      case a => try {
        if (a.toDouble > 0) return true
        } catch {
        case _: Exception =>
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
        case _: Exception => Console.err.println("Ошибка чтения\nточность установлена на значение 0.01")
      }; 0.01
    }
  }
}
