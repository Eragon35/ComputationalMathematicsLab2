import scala.io.StdIn

object Main {
  var accuracy: Double = 0.01
  var left: Double = 0
  var right: Double = 0
  var func: Double => Double = Math.pow(left, _) // TODO: rework to smth normal


  def main(args: Array[String]): Unit = {
    println(""" Вариант №2
      | Метод половинного деления
      | Метод секущих
      | Метод простой итерации
      | Заданная функция 1: −1,38x^3 − 5,42x^2 + 2,57x + 10,95
      | Функция 2: cos(x)""".stripMargin)

    while (true) {
      println("\nВыберите функцию: ") // TODO: add string with different functions
      func = ConsoleHandler.functionHandler(StdIn.readLine())
      // show graph of function
      var confirm = false
      while (!confirm) {
        println("Введите левый интервал: ")
        left = StdIn.readDouble()
        println("Введите правый интервал: ")
        right = StdIn.readDouble()
        if (right <= left) Console.err.println("Правый интеравл должен быть больше левого интервала")
        else {
          // show new graph
          println("Вас устраивает график? Он содержит корни")
          confirm = ConsoleHandler.agreeHandler(StdIn.readLine())
        }
      }
      println("Начинаем вычислять корни")
      BisectionMethod.solve() // find right root by 'Метод половинного деления'
      SecantMethod.solve() // find left root by 'Метод секущих'
      FixedPointIteration.solve() // find central root by 'Метод простой итерации'
    }
  }
}