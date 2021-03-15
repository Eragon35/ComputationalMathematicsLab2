import scala.io.StdIn

object Main {
  var accuracy: Double = 0.01
  var left: Double = -10
  var right: Double = 10
  var step: Double = 0.5
  var func: Double => Double = Math.pow(left, _)


  def main(args: Array[String]): Unit = {
    println(""" Вариант №2
      | Метод половинного деления
      | Метод секущих
      | Метод простой итерации
      | Заданная функция 1: −1,38x^3 − 5,42x^2 + 2,57x + 10,95
      | Функция 2: cos(x)""".stripMargin)

    while (true) {
      println("\nВыберите функцию: ")
      func = ConsoleHandler.functionHandler(StdIn.readLine())
      Graph.show()
      var confirmGraph = false
      println("Вас устраивает точность в 0.01 ?")
      accuracy = ConsoleHandler.accuracyAgreeHandler(StdIn.readLine())
      while (!confirmGraph) {
        println("Введите начало интервала: ")
        left = StdIn.readDouble()
        println("Введите конец интервала: ")
        right = StdIn.readDouble()
        if (right <= left) Console.err.println("Конец интеравл должен быть больше начала интервала")
        else {
          step = if (right - left < 5) (right - left) / 10 else 0.5
          Graph.show()
          println("Вас устраивает график? Он содержит корни")
          confirmGraph = ConsoleHandler.agreeHandler(StdIn.readLine())
        }
      }
      println("Начинаем вычислять корни:")
      BisectionMethod.solve() // find right root by 'Метод половинного деления'
      SecantMethod.solve() // find left root by 'Метод секущих'
      FixedPointIteration.solve() // find central root by 'Метод простой итерации'
      left = -10
      right = 10
      step = 0.5
    }
  }
}