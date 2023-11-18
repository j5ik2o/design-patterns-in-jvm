package s.decorator.inheritance

object Display {

  def ofString(string: String): Display = new StringDisplay(string)

  def ofSideBorder(display: Display, ch: Char): Display =
    new SideBorder(display, ch)

  def ofFullBorder(display: Display): Display = new FullBorder(display)

}

abstract class Display {

  def columns: Int

  def rows: Int

  def rowText(row: Int): String

  def show(): Unit = {
    for (i <- 0 until rows) {
      println(rowText(i))
    }
  }

}
