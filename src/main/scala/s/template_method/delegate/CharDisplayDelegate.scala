package s.template_method.delegate

final class CharDisplayDelegate(private val ch: Char) extends DisplayDelegate {
  override def open(): Unit = {
    Console.print("<<")
  }

  override def print(): Unit = {
    Console.print(ch)
  }

  override def close(): Unit = {
    Console.print(ch)
  }
}

