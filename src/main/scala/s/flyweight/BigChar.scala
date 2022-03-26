/* (C) 2022 */
package s.flyweight

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import scala.jdk.CollectionConverters._

class BigChar(var charname: Char) {
  private var fontdata: Option[String] = None

  try {
    val filename = "data/" + "big" + charname + ".txt"
    val sb = new StringBuilder
    for (line <- Files.readAllLines(Path.of(filename)).asScala) {
      sb.append(line)
      sb.append("\n")
    }
    fontdata = Some(sb.toString)
  } catch {
    case _: IOException =>
      this.fontdata = Some(charname + "?")
  }

  def print(): Unit = {
    fontdata.foreach(scala.Predef.print)
  }
}
