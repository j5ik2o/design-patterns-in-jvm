package s.template_method.like.functional

object Main extends App {
  val d1 = DisplayFactory.createChar('H')
  val d2 = DisplayFactory.createString("Hello, world.")

  d1.display()
  d2.display()
}
