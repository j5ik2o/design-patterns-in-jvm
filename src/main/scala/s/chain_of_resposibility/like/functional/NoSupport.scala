package s.chain_of_resposibility.like.functional

import s.chain_of_resposibility.Trouble

object NoSupport {
  def create(name: String): PartialFunction[Trouble, Trouble] = {
    new PartialFunction[Trouble, Trouble] {
      override def isDefinedAt(x: Trouble): Boolean = false

      override def apply(v1: Trouble): Trouble = throw new NotImplementedError()
    }
  }

}
