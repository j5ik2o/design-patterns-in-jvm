/* (C) 2022 */
package s.flyweight

class BigString(string: String) {

  private val bigChars: Seq[BigChar] =
    for (i <- 0 until string.length)
      yield BigCharFactory.getBigChar(string.charAt(i))

  def print(): Unit = {
    for (bc <- bigChars) {
      bc.print()
    }
  }
}
