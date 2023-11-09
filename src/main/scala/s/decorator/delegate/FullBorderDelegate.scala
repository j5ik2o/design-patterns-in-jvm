package s.decorator.delegate

final class FullBorderDelegate(private val display: Display) extends DisplayDelegate {
  override def columns: Int = 1 + display.getColumns + 1

  override def rows: Int = 1 + display.getRows + 1

  override def rowText(row: Int): String =
    if (row == 0) "+" + makeLine('-', display.getColumns) + "+"
    else if (row == display.getRows + 1) "+" + makeLine('-', display.getColumns) + "+"
    else "|" + display.getRowText(row - 1) + "|"

  private def makeLine(ch: Char, count: Int) = String.valueOf(ch).repeat(Math.max(0, count))
}
