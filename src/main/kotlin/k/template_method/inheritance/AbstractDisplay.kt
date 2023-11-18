/* (C)2022 */
package k.template_method.inheritance

abstract class AbstractDisplay {
  abstract fun open()

  abstract fun print()

  abstract fun close()

  fun display() {
    open()
    for (i in 0..4) {
      print()
    }
    close()
  }
}
