package s.chain_of_resposibility.like.functional

import s.chain_of_resposibility.Trouble

object MessagePrinter {
  def done(name: String, trouble: Trouble): Unit = {
    System.out.println(trouble + " is resolved by [" + name + "].")
  }

  def fail(trouble: Trouble): Unit = {
    System.out.println(trouble.toString + " cannot be resolved.")
  }
}
