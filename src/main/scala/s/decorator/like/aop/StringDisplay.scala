package s.decorator.like.aop

class StringDisplay(private val string: String) extends Display {
  override def columns: Int = string.length

  override def rows: Int = 1

  override def rowText(row: Int): String = {
    if (row != 0) throw new IndexOutOfBoundsException
    string
  }
}
