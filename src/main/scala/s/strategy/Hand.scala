package s.strategy

sealed trait Hand {
  val name: String
  val handValue: Int

  override def toString: String = name

  def isStrongerThan(h: Hand): Boolean = fight(h) == 1

  def isWeakerThan(h: Hand): Boolean = fight(h) == -1

  private def fight(h: Hand): Int =
    if (this eq h) 0
    else if ((this.handValue + 1) % 3 == h.handValue) 1
    else -1
}

object Hand {

  case object Rock extends Hand {
    override val name: String = "グー"
    override val handValue: Int = 0
  }

  case object Scissors extends Hand {
    override val name: String = "チョキ"
    override val handValue: Int = 1
  }

  case object Paper extends Hand {
    override val name: String = "パー"
    override val handValue: Int = 2
  }

  private val hands = Seq(Rock, Scissors, Paper)

  def getHand(handValue: Int): Hand = hands(handValue)

}
