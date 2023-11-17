package s.template_method.inheritance

object Main extends App {
  val d1: AbstractDisplay = DisplayFactory.createChar('H')
  val d2: AbstractDisplay = DisplayFactory.createString("Hello, world.")

  d1.display()
  d2.display()
}
