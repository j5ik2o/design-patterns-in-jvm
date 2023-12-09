package s.chain_of_resposibility.inheritance

object SupportFactory {
  def createNoSupport(name: String, next: Support) = new NoSupport(name, next)

  def createLimitSupport(name: String, limit: Int, next: Support) =
    new LimitSupport(name, limit, next)

  def createLimitSupport(name: String, limit: Int) =
    new LimitSupport(name, limit)

  def createSpecialSupport(name: String, number: Int, next: Support) =
    new SpecialSupport(name, number, next)

  def createOddSupport(name: String, next: Support) = new OddSupport(name, next)
}
