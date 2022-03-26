/* (C) 2022 */
package s.flyweight

import scala.collection.mutable

object BigCharFactory {
  private val singleton = new BigCharFactory

  def getInstance: BigCharFactory = singleton
}

class BigCharFactory private () {
  private val pool = mutable.Map.empty[String, BigChar]

  def getBigChar(charname: Char): BigChar = {
    var bc = pool(String.valueOf(charname))
    if (bc == null) { // ここでBigCharのインスタンスを生成
      bc = new BigChar(charname)
      pool.put(String.valueOf(charname), bc)
    }
    bc
  }
}
