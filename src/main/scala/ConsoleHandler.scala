import Main._

import scala.io.StdIn

object ConsoleHandler {
  def functionHandler(line: String): (Double => Double, Double => Double) = {
    line.trim.toLowerCase match {
      case "1" => (first, firstDerivative)
      case "2" => (second, secondDerivative)
      case "3" => (third, thirdDerivative)
      case "exit" | "e" | "no" | "n" => System.exit(0)
        (Math.pow(2, _), Math.pow(2, _)) // костыль чтобы иметь возможность выйти из программы
      case _ => Console.err.println("Такой функции нет, установлена первая функция")
        (first, firstDerivative)
    }
  }
  private def first(x: Double): Double = -1.38 * Math.pow(x, 3) - 5.42 * Math.pow(x, 2) + 2.57 * x + 10.95
  private def firstDerivative(x: Double): Double = -4.14 * Math.pow(x, 2) -10.84 * x + 2.57
  private def second(x: Double): Double = Math.cos(x)
  private def secondDerivative(x: Double): Double = -Math.sin(x)
  private def third(x: Double): Double = Math.pow(x, 3) - 0.78 * Math.pow(x, 2) - 0.826 * x + 0.145
  private def thirdDerivative(x: Double): Double = 3 * Math.pow(x, 2) - 1.56 * x - 0.826

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

  def confirmGraph(): Unit = {
    var confirmGraph = false
    while (!confirmGraph) {
    println("Хотите ввести в консоль данные?")
    if (agreeHandler(StdIn.readLine())) {
      println("Вас устраивает точность в 0.01 ?")
      accuracy = ConsoleHandler.accuracyAgreeHandler(StdIn.readLine())
      println("Введите начало интервала: ")
      left = StdIn.readDouble()
      println("Введите конец интервала: ")
      right = StdIn.readDouble()
      if (right <= left) {
        Console.err.println("Конец интеравл должен быть больше начала интервала")
        println("устанлвлен интервал [-5, 2]")
        left = -5
        right = 2
      }
      else step = if (right - left < 5) (right - left) / 10 else 0.5
    } else { print("Введите имя файла: ")
      ReadFromFile.read(StdIn.readLine().trim)
    }
    Graph.show()
    println("Вас устраивает график? Он содержит корни")
    confirmGraph = ConsoleHandler.agreeHandler(StdIn.readLine())
  }
}
