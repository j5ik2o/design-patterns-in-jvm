/* (C)2022 */
package k.flyweight

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

class BigChar(private val charname: Char) {
  private val fontdata: String = try {
    val filename = "data/big$charname.txt"
    val sb = StringBuilder()
    for (line in Files.readAllLines(Path.of(filename))) {
      sb.append(line)
      sb.append("\n")
    }
    sb.toString()
  } catch (_: IOException) {
    "$charname?"
  }

  fun print() {
    print(fontdata)
  }
}
