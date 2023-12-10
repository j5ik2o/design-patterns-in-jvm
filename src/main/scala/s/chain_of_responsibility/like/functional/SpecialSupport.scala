package s.chain_of_responsibility.like.functional

import s.chain_of_responsibility.Trouble

object SpecialSupport {

  def create(name: String, number: Int): PartialFunction[Trouble, Unit] = {
    case trouble if trouble.number == number =>
      MessagePrinter.done(name, trouble)
  }

}
