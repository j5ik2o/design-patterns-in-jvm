package s.chain_of_responsibility.inheritance.supports

import s.chain_of_responsibility.Trouble
import s.chain_of_responsibility.inheritance.Support

final class LimitSupport(
    name: String,
    private val limit: Int,
    next: Option[Support]
) extends Support(name, next) {
  def this(name: String, limit: Int) = {
    this(name, limit, None)
  }

  override protected def resolve(trouble: Trouble): Boolean =
    trouble.number < limit
}
