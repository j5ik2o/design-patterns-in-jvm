/* (C)2022 */
package k.flyweight

class BigString(string: String) {

  private val bigChars: List<BigChar> = string.map { BigCharFactory.getBigChar(it) }.toList()

  fun print() {
    for (bc in bigChars) bc.print()
  }
}
