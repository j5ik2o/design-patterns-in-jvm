package s.decorator.delegate

trait DisplayDelegate {
  def columns: Int

  def rows: Int

  def rowText(row: Int): String
}
