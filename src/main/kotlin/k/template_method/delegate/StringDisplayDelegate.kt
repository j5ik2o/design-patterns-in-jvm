package k.template_method.delegate

class StringDisplayDelegate(private val string: String) : DisplayDelegate {
  private val width: Int = string.length

  override fun open() {
    printLine()
  }

  override fun print() {
    println("|$string|")
  }

  override fun close() {
    printLine()
  }

  private fun printLine() {
    print("+")
    for (i in 0 until width) {
      print("-")
    }
    println("+")
  }
}
