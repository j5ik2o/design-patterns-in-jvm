package s.chain_of_resposibility.inheritance

import s.chain_of_resposibility.Trouble

abstract class Support(
    private val name: String,
    private val next: Option[Support]
) {
  def getName: String = name

  def support(trouble: Trouble): Unit = {
    if (resolve(trouble)) done(trouble)
    else if (next.isDefined) next.get.support(trouble)
    else fail(trouble)
  }

  override def toString: String = "[" + name + "]"

  protected def resolve(trouble: Trouble): Boolean

  protected def done(trouble: Trouble): Unit = {
    System.out.println(trouble.toString + " is resolved by " + this + ".")
  }

  protected def fail(trouble: Trouble): Unit = {
    System.out.println(trouble.toString + " cannot be resolved.")
  }
}
