package s.decorator.inheritance

object Main {
  def main(args: Array[String]): Unit = {
    val b1 = Display.ofString("Hello, world.")
    val b2 = Display.ofSideBorder(b1, '#')
    val b3 = Display.ofFullBorder(b2)
    b1.show()
    b2.show()
    b3.show()

    val b4 = Display.ofSideBorder(Display.ofFullBorder(Display.ofSideBorder(Display.ofFullBorder(Display.ofString("Hello, world.")), '*')), '/')
    b4.show()
  }
}
