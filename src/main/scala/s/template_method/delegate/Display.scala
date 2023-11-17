package s.template_method.delegate

final class Display(private val displayDelegate: DisplayDelegate) {
  def display(): Unit = {
    displayDelegate.open()
    for (_ <- 0 until 5) {
      displayDelegate.print()
    }
    displayDelegate.close()
  }
}