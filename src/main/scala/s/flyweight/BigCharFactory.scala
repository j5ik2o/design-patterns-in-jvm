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
    pool.getOrElseUpdate(String.valueOf(charname), new BigChar(charname))
  }
}
