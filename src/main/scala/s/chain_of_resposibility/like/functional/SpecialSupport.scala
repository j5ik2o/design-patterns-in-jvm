package s.chain_of_resposibility.like.functional

import s.chain_of_resposibility.Trouble

object SpecialSupport {

  def create(name: String, number: Int): PartialFunction[Trouble, Unit] = {
    case trouble if trouble.number == number =>
      MessagePrinter.done(name, trouble)
  }
}
