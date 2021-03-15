import Main._

import scala.Double.NaN
import scala.util.control.Breaks._

object BisectionMethod {
  def solve(): Unit = {
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
    var root: Double = (leftPointer + rightPointer) / 2
    var iterator: Int = 0
    println("1) Метод половинного деления:")
    println("it   a      b      x     f(a)    f(b)    f(x)  |a-b|")
    show(leftPointer, rightPointer, root, iterator)
    while (Math.abs(leftPointer - rightPointer) >= accuracy && Math.abs(func(root)) >= accuracy) {
      if ((func(leftPointer) > 0) == (func(root) > 0)) leftPointer = root
      else rightPointer = root
      root = (leftPointer + rightPointer) / 2
      iterator += 1
      show(leftPointer, rightPointer, root, iterator)
    }
    println("----------------------------------------------------")
  }

  private def show(a: Double, b: Double, x: Double, iterator: Int): Unit = {
    val funcA = func(a)
    val funcB = func(b)
    val funcX = func(x)
    val section = Math.abs(a - b)
    println(f"$iterator $a%1.4f $b%1.4f $x%1.4f $funcA%1.4f $funcB%1.4f $funcX%1.4f $section%1.4f")
  }
}
