package s.flyweight

class BigString(string: String) {

  private val bigChars: Vector[BigChar] =
    string.map(BigCharFactory.getBigChar).toVector

  def print(): Unit = {
    for (bc <- bigChars)
      bc.print()
  }
}
