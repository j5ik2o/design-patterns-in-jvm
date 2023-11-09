package k.flyweight

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

class BigChar(charName: Char) {
  private val fontData: String =
      try {
        val filename = "data/big$charName.txt"
        val sb = StringBuilder()
        for (line in Files.readAllLines(Path.of(filename))) {
          sb.append(line)
          sb.append("\n")
        }
        sb.toString()
      } catch (_: IOException) {
        "$charName?"
      }

  fun print() {
    print(fontData)
  }
}
