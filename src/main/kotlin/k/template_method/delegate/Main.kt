package k.template_method.delegate

object Main {
  @JvmStatic
  fun main(args: Array<String>) {
    val d1 = DisplayFactory.createChar('H')
    val d2 = DisplayFactory.createString("Hello, world.")

    d1.display()
    d2.display()
  }
}
