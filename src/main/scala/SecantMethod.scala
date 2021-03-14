import Main._

import scala.Double.NaN
import scala.util.control.Breaks._

object SecantMethod {
  def solve(): Unit = {
    val step: Double = if (right - left < 5) (right - left) / 10 else 0.5
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
      Console.err.println("На данном отрезке корней нет")
      return
    }
    // use Метод секущих
    println(s"$leftPointer $rightPointer")

  }

}
