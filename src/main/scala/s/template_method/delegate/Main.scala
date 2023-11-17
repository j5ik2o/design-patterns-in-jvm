package s.template_method.delegate

object Main extends App {
  val d1 = new Display(new CharDisplayDelegate('H'))
  val d2 = new Display(new StringDisplayDelegate("Hello, world."))

  d1.display()
  d2.display()
}
