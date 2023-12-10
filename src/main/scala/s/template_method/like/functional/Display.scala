package s.template_method.like.functional

final class Display(
                     opener: () => Unit,
                     printer: () => Unit,
                     closer: () => Unit
) {
  def display(): Unit = {
    opener()
    for (_ <- 0 until 5) {
      printer()
    }
    closer()
  }
}
