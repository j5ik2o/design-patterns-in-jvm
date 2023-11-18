package s.template_method.like.functional

import s.template_method.like.functional.Display._

object Display {
  type DisplayDelegate = () => Unit
}

final class Display(
    private val opener: DisplayDelegate,
    private val printer: DisplayDelegate,
    private val closer: DisplayDelegate
) {
  def display(): Unit = {
    opener()
    for (_ <- 0 until 5) {
      printer()
    }
    closer()
  }
}
