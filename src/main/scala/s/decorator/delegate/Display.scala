package s.decorator.delegate

object Display {
  def ofString(string: String): Display = new Display(
    new StringDisplayDelegate(string)
  )

  def ofSideBorder(display: Display, ch: Char): Display = new Display(
    new SideBorderDelegate(display, ch)
  )

  def ofFullBorder(display: Display): Display = new Display(
    new FullBorderDelegate(display)
  )
}

final class Display(private val delegate: DisplayDelegate) {
  def columns: Int = delegate.columns

  def rows: Int = delegate.rows

  def rowText(row: Int): String = delegate.rowText(row)

  private[delegate] def show(): Unit = {
    for (i <- 0 until rows) {
      println(rowText(i))
    }
  }
}
