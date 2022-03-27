/* (C)2022 */
package k.flyweight

import java.util.concurrent.ConcurrentHashMap

object BigCharFactory {
  private val pool: MutableMap<String, BigChar> = ConcurrentHashMap()

  fun getBigChar(charName: Char): BigChar {
    return pool.getOrDefault(charName.toString(), BigChar(charName))
  }
}
