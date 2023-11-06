package s.template_method.delegate

import j.template_method.delegate.DisplayDelegate

final class Display(private val opener: DisplayDelegate, private val printer: DisplayDelegate, private val closer: DisplayDelegate) {
  def display(): Unit = {
    opener.open()
    for (i <- 0 until 5) {
      printer.print()
    }
    closer.close()
  }
}