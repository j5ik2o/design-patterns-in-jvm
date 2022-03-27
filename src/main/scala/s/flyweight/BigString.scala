/* (C) 2022 */
package s.flyweight

class BigString(string: String) {

  private val bigChars: Seq[BigChar] =
    for (c <- string)
      yield { BigCharFactory.getBigChar(c) }

  def print(): Unit = {
    for (bc <- bigChars)
      bc.print()
  }
}
