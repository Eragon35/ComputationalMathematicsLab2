import Main._
import scalax.chart.module.Charting._

object Graph {
  def show(): Unit = {
    val dataset = Seq(
      ("Выбранная функция", for(x <- left to right by step) yield (x, func(x))),
      ("0", for(x <- left to right by step) yield (x, 0.0))
    )
    XYLineChart(dataset.toXYSeriesCollection()).show("График функции", (1280, 720), scrollable = true)
  }
}
