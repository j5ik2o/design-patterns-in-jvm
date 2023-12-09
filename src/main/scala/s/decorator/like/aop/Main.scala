package s.decorator.like.aop

object Main {
  def main(args: Array[String]): Unit = {
    val b1 = new StringDisplay("Hello, world.")
    val b2 = new StringDisplay("Hello, world.") with SideBorder {
      override def borderChar: Char = '#'
    }
    val b3 = new StringDisplay("Hello, world.")
      with SideBorder
      with FullBorder {
      override def borderChar: Char = '#'
    }
    b1.show()
    b2.show()
    b3.show()

    /** Can't build like this
      *  val b4 = Display.ofSideBorder(
      *      Display.ofFullBorder(
      *        Display.ofSideBorder(
      *          Display.ofFullBorder(Display.ofString("Hello, world.")),
      *          '*'
      *        )
      *      ),
      *      '/'
      *    )
      *    b4.show()
      */
  }
}
