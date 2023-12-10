package s.chain_of_responsibility.like.functional

import s.chain_of_responsibility.Trouble

object MessagePrinter {
  def done(name: String, trouble: Trouble): Unit = {
    System.out.println(trouble.toString + " is resolved by [" + name + "].")
  }

  def fail(trouble: Trouble): Unit = {
    System.out.println(trouble.toString + " cannot be resolved.")
  }
}
