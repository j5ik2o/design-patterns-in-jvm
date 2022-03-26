/* (C) 2022 */
package s.flyweight

import j.flyweight.BigString

object Main {
  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      println("Usage: java Main digits")
      println("Example: java Main 1212123")
      System.exit(0)
    }
    val bs = new BigString(args(0))
    bs.print()
  }
}
