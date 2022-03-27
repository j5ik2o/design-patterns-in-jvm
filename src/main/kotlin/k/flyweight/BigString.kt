/* (C)2022 */
package k.flyweight

class BigString(string: String) {
  
  private val bigChars: Array<BigChar?>

  init {
    bigChars = arrayOfNulls(string.length)
    for (i in bigChars.indices) {
      bigChars[i] = BigCharFactory.getBigChar(string[i])
    }
  }

  fun print() {
    for (bc in bigChars) {
      bc!!.print()
    }
  }
}
