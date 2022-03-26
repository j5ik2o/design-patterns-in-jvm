/* (C) 2022 */
package s.flyweight

class BigString(val string: String) {
  val factory: BigCharFactory = BigCharFactory.getInstance
  private val bigchars: Array[BigChar] = new Array[BigChar](string.length)

  for (i <- bigchars.indices) {
    bigchars(i) = factory.getBigChar(string.charAt(i))
  }

  def print(): Unit = {
    for (bc <- bigchars) {
      bc.print()
    }
  }
}
