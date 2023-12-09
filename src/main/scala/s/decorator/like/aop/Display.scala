package s.decorator.like.aop

trait Display {
  def columns: Int

  def rows: Int

  def rowText(row: Int): String

  def show(): Unit = {
    for (i <- 0 until rows) {
      println(rowText(i))
    }
  }
}
