/* (C)2022 */
package k.flyweight

import j.flyweight.BigChar
import j.flyweight.BigCharFactory

class BigString(string: String) {
  private val bigchars: Array<BigChar?>

  init {
    val factory = BigCharFactory.getInstance()
    bigchars = arrayOfNulls(string.length)
    for (i in bigchars.indices) {
      bigchars[i] = factory.getBigChar(string[i])
    }
  }

  fun print() {
    for (bc in bigchars) {
      bc!!.print()
    }
  }
}
