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

object Display {
  def ofString(string: String): Display = new StringDisplay(string)

  def ofSideBorder(string: String, ch: Char): Display = {
    new StringDisplay(string) with SideBorder {
      override def borderChar: Char = ch
    }
  }
}
