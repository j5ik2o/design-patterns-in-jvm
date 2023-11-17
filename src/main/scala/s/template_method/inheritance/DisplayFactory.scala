package s.template_method.inheritance

object DisplayFactory {
  def createString(string: String): AbstractDisplay = {
    new StringDisplay(string)
  }

  def createChar(char: Char): AbstractDisplay = {
    new CharDisplay(char)
  }
}
