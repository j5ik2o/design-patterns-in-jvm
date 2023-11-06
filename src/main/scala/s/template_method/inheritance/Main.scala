/* (C) 2022 */
package s.template_method.inheritance

object Main {
  def main(args: Array[String]): Unit = {
    val d1: AbstractDisplay = new CharDisplay('H')
    val d2: AbstractDisplay = new StringDisplay("Hello, world.")

    d1.display()
    d2.display()
  }
}
