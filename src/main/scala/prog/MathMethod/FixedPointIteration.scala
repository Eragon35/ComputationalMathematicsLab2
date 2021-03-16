package prog.MathMethod

import prog.Main._

object FixedPointIteration {
  def solve(): Unit = {
    var sing: Boolean = func(left) >= 0
    var roots = Vector[Double]()
    for (i <- left to right + step by step) { // going right if find other sign add position to vector & change sign
      if (func(i) < 0 == sing) {
        sing = !sing
        roots = roots :+ i
      }
    }
    if (roots.isEmpty) {
      answer += "На данном отрезке корней нет"
      return
    }

    val rightPointer: Double = roots((roots.size + 1) / 2 - 1)
    val leftPointer: Double = rightPointer - step
    var iterator: Int = 0
    var x0 = if (funcDerivative(left) > funcDerivative(right)) left else right
    val lambda = -1 / funcDerivative(x0)
    val leftAnswer = 1 + lambda * funcDerivative(left)
    val rightAnswer = 1 + lambda * funcDerivative(right)
    answer += (f"left answer = $leftAnswer%1.4f, right answer = $rightAnswer%1.4f")
    answer += (f"𝜆 = $lambda%1.4f")
    answer += "3) Метод простой итерации"
    answer += "it   xi    xi+1   φ(xi+1) f(xi+1) |xi+1 - xi|"
    var xi = x0 + lambda * func(x0)
    show(x0, xi, iterator, lambda)
    while (Math.abs(x0 - xi) >= accuracy && Math.abs(func(xi)) >= accuracy) {
      x0 = xi
      xi = x0 + lambda * func(x0)
      iterator += 1
      show(x0, xi, iterator, lambda)
    }
    answer += "---------------------------------------------"
  }

  private def show(x0: Double, xi: Double, iterator: Int, lambda: Double): Unit = {
    val fix = xi + lambda * func(xi)
    val funcX = func(xi)
    val section = Math.abs(x0 - xi)
    answer += f"$iterator $x0%1.4f $xi%1.4f $fix%1.4f  $funcX%1.4f  $section%1.4f"
  }
}
