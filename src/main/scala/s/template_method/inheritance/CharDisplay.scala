package s.template_method.inheritance

final class CharDisplay(val ch: Char) extends AbstractDisplay {

  override def open(): Unit = {
    scala.Predef.print("<<")
  }

  override def print(): Unit = {
    scala.Predef.print(ch)
  }

  override def close(): Unit = {
    scala.Predef.println(">>")
  }

}
