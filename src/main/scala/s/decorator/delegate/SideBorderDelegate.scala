package s.decorator.delegate

final class SideBorderDelegate(private val display: Display, private val borderChar: Char) extends DisplayDelegate {
  override def columns: Int = 1 + display.columns + 1

  override def rows: Int = display.rows

  override def rowText(row: Int): String = borderChar.toString + display.rowText(row) + borderChar.toString
}
