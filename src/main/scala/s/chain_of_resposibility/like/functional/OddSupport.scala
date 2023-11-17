package s.chain_of_resposibility.like.functional

import s.chain_of_resposibility.Trouble

object OddSupport {
  def create(name: String): PartialFunction[Trouble, Unit] = {
    case trouble if trouble.number % 2 == 1 =>
      MessagePrinter.done(name, trouble)
  }
}
