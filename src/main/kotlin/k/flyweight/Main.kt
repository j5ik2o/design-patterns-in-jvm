/* (C)2022 */
package k.flyweight

import j.flyweight.BigString

object Main {
  @JvmStatic
  fun main(args: Array<String>) {
    if (args.isEmpty()) {
      println("Usage: java Main digits")
      println("Example: java Main 1212123")
      System.exit(0)
    }
    val bs = BigString(args[0])
    bs.print()
  }
}
