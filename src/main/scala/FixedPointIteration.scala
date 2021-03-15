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
    println("3) Метод простой итерации")
    println("it   xi    xi+1   φ(xi+1) f(xi+1) |xi+1 - xi|")

    println("---------------------------------------------")
  }

}
