package k.template_method.delegate

class CharDisplayDelegate(private val ch: Char = 0.toChar()) : DisplayDelegate {
  override fun open() {
    print("<<")
  }

  override fun print() {
    print(ch)
  }

  override fun close() {
    println(">>")
  }
}
