/* (C) 2022 */
package s.flyweight

class BigString(string: String) {

  private val bigChars: Seq[BigChar] =
    string.map(BigCharFactory.getBigChar)

  def print(): Unit = {
    for (bc <- bigChars)
      bc.print()
  }
}
