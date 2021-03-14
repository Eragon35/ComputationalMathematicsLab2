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
    var root: Double = (leftPointer + rightPointer) / 2
    var counter: Int = 0
    println("Метод половинного деления")
    println("it   a      b      x     f(a)    f(b)    f(x)  |a-b|")
    show(leftPointer, rightPointer, root, counter)
    while (Math.abs(leftPointer - rightPointer) >= accuracy && func(root) != 0.0) {
      if ((func(leftPointer) > 0) == (func(root) > 0)) leftPointer = root
      else rightPointer = root
      root = (leftPointer + rightPointer) / 2
      counter += 1
      show(leftPointer, rightPointer, root, counter)
    }
    println("----------------------------------------------------")
  }

  def show(a: Double, b: Double, x: Double, iterator: Int): Unit = {
    val funca = func(a)
    val funcb = func(b)
    val funcx = func(x)
    val section = Math.abs(a - b)
    println(f"$iterator $a%1.4f $b%1.4f $x%1.4f $funca%1.4f $funcb%1.4f $funcx%1.4f $section%1.4f")
  }
}
