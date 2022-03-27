/* (C) 2022 */
package s.flyweight

import java.util.concurrent.ConcurrentHashMap
import scala.jdk.CollectionConverters._

object BigCharFactory {
  private val pool = new ConcurrentHashMap[String, BigChar]().asScala

  def getBigChar(charName: Char): BigChar = {
    pool.getOrElseUpdate(String.valueOf(charName), new BigChar(charName))
  }
}
