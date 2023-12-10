package s.chain_of_responsibility.inheritance.supports

import s.chain_of_responsibility.Trouble
import s.chain_of_responsibility.inheritance.Support

final class SpecialSupport(
    name: String,
    private val number: Int,
    next: Option[Support]
) extends Support(name, next) {
  def this(name: String, number: Int) = {
    this(name, number, None)
  }

  override protected def resolve(trouble: Trouble): Boolean =
    trouble.number == number
}
