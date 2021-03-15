import Main._

object FixedPointIteration {
  def solve(): Unit = {
    var sing: Boolean = func(left) >= 0
    var roots = Vector[Double]()
    for (i <- left to right+step by step ){ // going right if find other sign add position to vector & change sign
      if (func(i) < 0 == sing) {
        sing = !sing
        roots = roots :+ i
      }
    }
    if (roots.isEmpty){
      Console.err.println("На данном отрезке корней нет")
      return
    }
    val rightPointer: Double = roots((roots.size + 1) / 2 - 1)
    val leftPointer: Double = rightPointer - step
    var iterator: Int = 0
    println("3) Метод простой итерации")
    println("it   xi    xi+1   φ(xi+1) f(xi+1) |xi+1 - xi|")
    var x0 = if (funcDerivative(leftPointer) > funcDerivative(rightPointer)) leftPointer else rightPointer
    val lambda = -1 / funcDerivative(x0)
    var xi = x0 + lambda * func(x0)
    show(x0, xi, iterator)
    while (Math.abs(x0 - xi) > accuracy){
      x0 = xi
      xi = x0 + lambda * func(x0)
      iterator += 1
      show(x0, xi, iterator)
    }
    
    println("---------------------------------------------")
  }

  private def show(x0: Double, xi: Double, iterator: Int): Unit = {
    val fix = func(xi)
    val funcX = func(xi)
    val section = Math.abs(x0 - xi)
    println(f"$iterator $x0%1.4f $xi%1.4f $fix%1.4f  $funcX%1.4f  $section%1.4f")
  }
}
