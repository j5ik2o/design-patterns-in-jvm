package s.decorator.like.aop

import scala.util.DynamicVariable

trait SideBorder extends Display {
  def borderChar: Char

  abstract override def columns: Int = 1 + super.columns + 1

  abstract override def rows: Int = super.rows

  abstract override def rowText(row: Int): String =
    borderChar.toString + super.rowText(row) + borderChar.toString
}
