import scala.io.StdIn

object Main {
  var left: Double = 0
  var right: Double = 0
  var func: Double => Double = Math.pow(left, _) // TODO: rework to smth normal


  def main(args: Array[String]): Unit = {
    println(""" Вариант №2
      | Метод половинного деления
      | Метод секущих
      | Метод простой итерации
      | Заданная функция: −1,38x^3 − 5,42x^2 + 2,57x + 10,95""".stripMargin)

    while (true) {
      println("\nfunctions" + "\nВыберите функцию: ")
      func = ConsoleHandler.functionHandler(StdIn.readLine())
      // show graph of function
      var confirm = false
      while (!confirm) {
        println("Введите левый интервал: ")
        left = StdIn.readDouble()
        println("Введите правый интервал: ")
        right = StdIn.readDouble()
        if (right <= left) println("ты ебанная макака") // TODO: change to smth normal
        else {
          // show new graph
          println("Вас устраивает график? Он содержит корни")
          confirm = ConsoleHandler.agreeHandler(StdIn.readLine())
        }
      }
      // find right root by 'Метод половинного деления'
      // find left root by 'Метод секущих'
      // find central root by 'Метод простой итерации'

    }
  }
}