import Main._

import scala.Double.NaN
import scala.util.control.Breaks._

object BisectionMethod {
  def solve(): Unit = {
    val step: Double = if (right - left < 5) (right - left) / 10 else 0.5
    val sing: Boolean = func(right) >= 0
    var leftPointer: Double = NaN
    var rightPointer: Double = NaN
    breakable {
      for (i <- right to left - step by -step) { // going left until find first position with other sign
        if (func(i) < 0 == sing) {
          leftPointer = i
          rightPointer = i + step // we can use original right border, but it will be quick if we use the closest one
          break
        }
      }
    }
    if (leftPointer.isNaN) {
      Console.err.println("На данном отрезке корней нет")
      return
    }
    // use Метод половинного деления
    println(s"$leftPointer $rightPointer")
//    var root: Double = (leftPointer + rightPointer) / 2
//    var counter: Int = 0
//    while (Math.abs(leftPointer - rightPointer) >= accuracy || func(root) != 0.0) {
//
//    }
  }

  def show(a: Double, b: Double, x: Double): Unit = {

  }

}
