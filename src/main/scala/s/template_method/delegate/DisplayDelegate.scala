package s.template_method.delegate

trait DisplayDelegate {
  def open(): Unit

  def print(): Unit

  def close(): Unit
}
