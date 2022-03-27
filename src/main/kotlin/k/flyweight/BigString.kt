/* (C)2022 */
package k.flyweight

class BigString(string: String) {

  private val bigChars: List<BigChar> =
      sequence { for (c in string) yield(BigCharFactory.getBigChar(c)) }.toList()

  fun print() {
    for (bc in bigChars) bc.print()
  }
}
