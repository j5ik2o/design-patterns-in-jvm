package s.chain_of_resposibility.like.functional

import s.chain_of_resposibility.Trouble

final case class ControlBreak(trouble: Trouble, controlBreak: Boolean) {
  def otherwise(f: Trouble => Unit): Unit = {
    if (!controlBreak) {
      f(trouble)
    }
  }
}
