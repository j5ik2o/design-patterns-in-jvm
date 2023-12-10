package s.chain_of_responsibility.like.functional

import s.chain_of_responsibility.Trouble

object NoSupport {
  def create(name: String): PartialFunction[Trouble, Trouble] = {
    new PartialFunction[Trouble, Trouble] {
      override def isDefinedAt(trouble: Trouble): Boolean = false

      override def apply(trouble: Trouble): Trouble =
        throw new NotImplementedError()
    }
  }

}
