package s.chain_of_resposibility.inheritance.supports

import s.chain_of_resposibility.Trouble
import s.chain_of_resposibility.inheritance.Support

final class OddSupport(name: String, next: Option[Support])
    extends Support(name, next) {
  def this(name: String) = {
    this(name, None)
  }

  override protected def resolve(trouble: Trouble): Boolean =
    trouble.number % 2 == 1
}