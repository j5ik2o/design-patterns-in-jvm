package s.template_method.delegate

object DisplayFactory {
  def createString(string: String): Display = {
    new Display(new StringDisplayDelegate(string))
  }

  def createChar(ch: Char): Display = {
    new Display(new CharDisplayDelegate(ch))
  }
}
