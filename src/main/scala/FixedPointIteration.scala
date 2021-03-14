import Main.{func, left, right}

object FixedPointIteration {
  def solve(): Unit = {
    val step: Double = if (right - left < 5) (right - left) / 10 else 0.5
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
    // use Метод простой итерации
    println(s"$leftPointer $rightPointer")

  }

}
