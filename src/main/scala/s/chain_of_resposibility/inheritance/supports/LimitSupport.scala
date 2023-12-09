package s.chain_of_resposibility.inheritance.supports

import s.chain_of_resposibility.Trouble
import s.chain_of_resposibility.inheritance.Support

final class LimitSupport(
    name: String,
    private val limit: Int // この番号未満なら解決できる
    ,
    next: Support
) extends Support(name, next) {
  def this(name: String, limit: Int) {
    this(name, limit, null)
  }

  override protected def resolve(trouble: Trouble): Boolean =
    trouble.number < limit
}
