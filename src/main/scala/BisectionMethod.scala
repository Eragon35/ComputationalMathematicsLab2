import Main._

import scala.Double.NaN
import scala.util.control.Breaks.break

object BisectionMethod {
  def solve(): Unit = {
    val step: Double = if (right - left < 5) (right - left) / 10 else 0.5
    val sing: Boolean = func(right) >= 0
    var pointer: Double = NaN
    for (i <- right to left-step by -step ){ // going left until find first position with other sign
      if (func(i) < 0 == sing) {
        pointer = i
        break
      }
    }
    if (pointer.isNaN) {
      Console.err.println("На данном отрезке корней нет")
      return
    }
    // find sign on the right limit
    // going left until find another sign => find true left
    // use bisection method
  }

}
