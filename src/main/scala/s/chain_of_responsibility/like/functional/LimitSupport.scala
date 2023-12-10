package s.chain_of_responsibility.like.functional

import s.chain_of_responsibility.Trouble

object LimitSupport {
  def create(name: String, limit: Int): PartialFunction[Trouble, Unit] = {
    case trouble if trouble.number < limit =>
      MessagePrinter.done(name, trouble)
  }
}
