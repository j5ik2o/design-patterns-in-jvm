/* (C)2022 */
package k.flyweight

import j.flyweight.BigChar

class BigCharFactory private constructor() {
  private val pool: MutableMap<String, BigChar> = HashMap()
  @Synchronized
  fun getBigChar(charname: Char): BigChar {
    return pool.getOrDefault(charname.toString(), BigChar(charname))
  }

  companion object {
    val instance = BigCharFactory()
  }
}
