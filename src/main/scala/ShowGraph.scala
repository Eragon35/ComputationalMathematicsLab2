import Main._
import scalax.chart.module.Charting._

object ShowGraph {
  def show(): Unit = {
    val dataset = Seq(
      ("our function", for(x <- left to right by step) yield (x, func(x))),
      ("y = 0", for(x <- left to right by step) yield (x, 0.0))
    )
    val chart = XYLineChart(dataset.toXYSeriesCollection())
    chart.show()
  }
}
