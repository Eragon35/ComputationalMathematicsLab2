import Main._

import scala.Double.NaN
import scala.util.control.Breaks._

object SecantMethod {
  def solve(): Unit = {
    val sing: Boolean = func(left) >= 0
    var leftPointer: Double = NaN
    var rightPointer: Double = NaN
    breakable {
      for (i <- left to right + step by step) { // going right until find first position with other sign
        if (func(i) < 0 == sing) {
          rightPointer = i
          leftPointer = i - step // we can use original left border, but it will be quick if we use the closest one
          break
        }
      }
    }
    if (rightPointer.isNaN) {
      answer += ("На данном отрезке корней нет")
      return
    }
    answer += ("2) Метод секущих")
    answer += ("it  xi-1    xi      xi+1  f(xi+1) |xi+1 - xi|")
    var iterator: Int = 0
    var xi = rightPointer
    var xLast = leftPointer
    var root = findRoot(xLast, xi)
    show(xLast, xi, root, iterator)
    while (Math.abs(root - xi) >= accuracy) {
      xLast = xi
      xi = root
      root = findRoot(xLast, xi)
      iterator += 1
      show(xLast, xi, root, iterator)
    }
    answer += ("---------------------------------------------")
  }

  private def findRoot(xLast: Double, xi: Double): Double = {
    xi - (xi - xLast) / (func(xi) - func(xLast)) * func(xi)
  }
  private def show(xLast: Double, xi: Double, root: Double, iterator: Int): Unit = {
    val funcX = func(root)
    val section = Math.abs(root - xi)
    answer += (f"$iterator $xLast%1.4f $xi%1.4f $root%1.4f $funcX%1.4f $section%1.4f")
  }
}
