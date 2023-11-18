package k.template_method.inheritance

class DisplayFactory {
  companion object {
    fun createChar(char: Char): Display {
      return CharDisplay(char)
    }

    fun createString(string: String): Display {
      return StringDisplay(string)
    }
  }
}
