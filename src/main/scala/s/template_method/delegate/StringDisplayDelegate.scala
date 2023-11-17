package s.template_method.delegate

final class StringDisplayDelegate(private val string: String) extends DisplayDelegate {
  private val width = string.length

  override def open(): Unit = {
    printLine()
  }

  override def print(): Unit = {
    Console.println("|" + string + "|")
  }

  override def close(): Unit = {
    printLine()
  }

  private def printLine(): Unit = {
    Console.print("+")
    for (_ <- 0 until width) {
      Console.print("-")
    }
    Console.println("+")
  }
}
