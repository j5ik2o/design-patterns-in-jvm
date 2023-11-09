package s.decorator.inheritance

object Display {

  def ofString(string: String) = new StringDisplay(string)

  def ofSideBorder(display: Display, ch: Char) = new SideBorder(display, ch)

  def ofFullBorder(display: Display): FullBorder = new FullBorder(display)

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
