/* (C)2022 */
package k.flyweight

import j.flyweight.BigChar

class BigCharFactory private constructor() {
  private val pool: MutableMap<String, BigChar> = HashMap()
  @Synchronized
  fun getBigChar(charname: Char): BigChar {
    var bc = pool[charname.toString()]
    if (bc == null) {
      // ここでBigCharのインスタンスを生成
      bc = BigChar(charname)
      pool[charname.toString()] = bc
    }
    return bc
  }

  companion object {
    val instance = BigCharFactory()
  }
}
