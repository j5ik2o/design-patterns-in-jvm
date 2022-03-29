/* (C) 2022 */
package s.strategy

import java.security.SecureRandom

case class ProbStrategy(
    prevHandValue: Int,
    currentHandValue: Int,
    history: Vector[Vector[Int]]
) extends Strategy {
  private val random = new SecureRandom()

  def this() = {
    this(
      0,
      0,
      Vector(Vector(1, 1, 1), Vector(1, 1, 1), Vector(1, 1, 1))
    )
  }

  override def nextHand: (Strategy, Hand) = {
    val bet = random.nextInt(getSum(currentHandValue))
    val handValue =
      if (bet < history(currentHandValue)(0)) 0
      else if (
        bet < history(currentHandValue)(0) + history(currentHandValue)(1)
      )
        1
      else 2
    (
      ProbStrategy(currentHandValue, handValue, history),
      Hand.getHand(handValue)
    )
  }

  private def getSum(handValue: Int): Int = {
    history(handValue).sum
  }

  override def study(win: Boolean): ProbStrategy = {
    val h = if (win) {
      val v = history(prevHandValue)(currentHandValue)
      val up = history(prevHandValue).updated(currentHandValue, v + 1)
      history.updated(prevHandValue, up)
    } else {
      val v = history(prevHandValue)((currentHandValue + 1) % 3)
      val up = history(prevHandValue).updated((currentHandValue + 1) % 3, v + 1)
      val history_updated = history.updated(prevHandValue, up)
      val v2 = history_updated(prevHandValue)((currentHandValue + 2) % 3)
      val up2 = history_updated(prevHandValue).updated(
        (currentHandValue + 2) % 3,
        v2 + 1
      )
      history_updated.updated(prevHandValue, up2)
    }
    ProbStrategy(prevHandValue, currentHandValue, h)
  }
}
