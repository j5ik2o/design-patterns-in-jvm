package k.template_method.delegate

class Display(
    private val delegate: DisplayDelegate,
) {
  fun display() {
    delegate.open()
    for (i in 0..4) {
      delegate.print()
    }
    delegate.close()
  }
}
