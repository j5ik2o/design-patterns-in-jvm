package s.decorator.delegate

final class StringDisplayDelegate(private val string: String)
    extends DisplayDelegate {
  override def columns: Int = string.length

  override def rows = 1

  override def rowText(row: Int): String = {
    if (row != 0) throw new IndexOutOfBoundsException
    string
  }
}
