package k.template_method.delegate

class DisplayFactory {
  companion object {
    fun createChar(char: Char): Display {
      return Display(CharDisplayDelegate(char))
    }

    fun createString(string: String): Display {
      return Display(StringDisplayDelegate(string))
    }
  }
}
