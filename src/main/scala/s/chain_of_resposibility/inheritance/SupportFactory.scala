package s.chain_of_resposibility.inheritance

import s.chain_of_resposibility.inheritance.supports.{
  LimitSupport,
  NoSupport,
  OddSupport,
  SpecialSupport
}

object SupportFactory {
  def createNoSupport(name: String, next: Option[Support]) =
    new NoSupport(name, next)

  def createLimitSupport(name: String, limit: Int, next: Option[Support]) =
    new LimitSupport(name, limit, next)

  def createLimitSupport(name: String, limit: Int) =
    new LimitSupport(name, limit)

  def createSpecialSupport(name: String, number: Int, next: Option[Support]) =
    new SpecialSupport(name, number, next)

  def createOddSupport(name: String, next: Option[Support]) =
    new OddSupport(name, next)
}
