package s.decorator.delegate

final class FullBorderDelegate(private val display: Display) extends DisplayDelegate {
  override def columns: Int = 1 + display.columns + 1

  override def rows: Int = 1 + display.rows + 1

  override def rowText(row: Int): String =
    if (row == 0) "+" + makeLine('-', display.columns) + "+"
    else if (row == display.rows + 1) "+" + makeLine('-', display.columns) + "+"
    else "|" + display.rowText(row - 1) + "|"

  private def makeLine(ch: Char, count: Int) = String.valueOf(ch).repeat(Math.max(0, count))
}
