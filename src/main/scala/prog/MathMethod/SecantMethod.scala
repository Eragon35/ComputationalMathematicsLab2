package prog.MathMethod

import prog.Main._

import scala.Double.NaN
import scala.util.control.Breaks.{break, breakable}

object SecantMethod {
  def solve(): Unit = {
//    val sing: Boolean = func(left) >= 0
//    var leftPointer: Double = NaN
//    var rightPointer: Double = NaN
//    breakable { // выввести х0 - начальное приближение
//      for (i <- left to right + step by step) { // going right until find first position with other sign
//        if (func(i) < 0 == sing) {
//          rightPointer = i
//          leftPointer = i - step // we can use original left border, but it will be quick if we use the closest one
//          break
//        }
//      }
//    }
//    if (rightPointer.isNaN) {
//      answer += "На данном отрезке корней нет"
//      return
//    }

    var x0 = if (func(left) * funcSecondDerivative(left) > 0) left else right
    answer += "2) Метод секущих"
    answer += ("Первое приближение: x0 = " + x0)
    val leftAnswer = func(left) * funcSecondDerivative(left)
    val rightAnswer = func(right) * funcSecondDerivative(right)
    answer += (f"left = $leftAnswer%1.4f, right = $rightAnswer%1.4f")
    answer += "it  xi-1    xi      xi+1  f(xi+1) |xi+1 - xi|"
    var iterator: Int = 0
    var xi = x0 + 0.5
    var root = findRoot(x0, xi)
    show(x0, xi, root, iterator)
    while (Math.abs(root - xi) >= accuracy) {
      x0 = xi
      xi = root
      root = findRoot(x0, xi)
      iterator += 1
      show(x0, xi, root, iterator)
    }
    answer += "---------------------------------------------"
  }

  private def findRoot(xLast: Double, xi: Double): Double = xi - (xi - xLast) / (func(xi) - func(xLast)) * func(xi)
  private def show(xLast: Double, xi: Double, root: Double, iterator: Int): Unit = {
    val funcX = func(root)
    val section = Math.abs(root - xi)
    answer += f"$iterator $xLast%1.4f $xi%1.4f $root%1.4f $funcX%1.4f $section%1.4f"
  }
}
