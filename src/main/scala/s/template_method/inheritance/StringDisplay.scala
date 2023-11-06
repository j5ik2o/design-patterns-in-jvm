/* (C) 2022 */
package s.template_method.inheritance

class StringDisplay(val string: String) extends AbstractDisplay {
  val width: Int = string.length

  override def open(): Unit = {
    printLine()
  }

  override def print(): Unit = {
    println("|" + string + "|")
  }

  override def close(): Unit = {
    printLine()
  }

  private def printLine(): Unit = {
    scala.Predef.print("+")
    for (i <- 0 until width) {
      scala.Predef.print("-")
    }
    scala.Predef.println("+")
  }
}
