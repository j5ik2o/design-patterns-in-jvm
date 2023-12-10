package s.chain_of_responsibility.like.functional

import s.chain_of_responsibility.Trouble

object OddSupport {
  def create(name: String): PartialFunction[Trouble, Unit] = {
    case trouble if trouble.number % 2 == 1 =>
      MessagePrinter.done(name, trouble)
  }
}
