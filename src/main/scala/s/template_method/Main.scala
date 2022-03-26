/* (C) 2022 */
package s.template_method

object Main {
  def main(args: Array[String]): Unit = { // 'H'を持ったCharDisplayのインスタンスを1個作る
    val d1: AbstractDisplay = new CharDisplay('H')
    val d2: AbstractDisplay = new StringDisplay("Hello, world.")

    d1.display()
    d2.display()
  }
}
