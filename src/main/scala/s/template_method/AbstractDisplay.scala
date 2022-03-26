/* (C) 2022 */
package s.template_method

abstract class AbstractDisplay {
  def open(): Unit

  def print(): Unit

  def close(): Unit

  final def display(): Unit = {
    open()
    for (i <- 0 until 5) {
      print()
    }
    close()
  }
}
