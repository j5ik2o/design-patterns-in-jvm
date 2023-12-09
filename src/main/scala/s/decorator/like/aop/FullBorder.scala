package s.decorator.like.aop

trait FullBorder extends Display {
  abstract override def columns: Int = 1 + super.columns + 1

  abstract override def rows: Int = 1 + super.rows + 1

  abstract override def rowText(row: Int): String =
    if (row == 0) "+" + makeLine('-', super.columns) + "+"
    else if (row == super.rows + 1) "+" + makeLine('-', super.columns) + "+"
    else "|" + super.rowText(row - 1) + "|"

  private def makeLine(ch: Char, count: Int) =
    String.valueOf(ch).repeat(Math.max(0, count))
}
