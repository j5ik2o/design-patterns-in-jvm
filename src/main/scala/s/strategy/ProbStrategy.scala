/* (C) 2022 */
package s.strategy

import java.util.Random

case class ProbStrategy(
    seed: Int,
    prevHandValue: Int,
    currentHandValue: Int,
    history: Array[Array[Int]]
) extends Strategy {
  private val random = new Random(seed)

  def this(seed: Int) = {
    this(
      seed,
      0,
      0,
      Array(Array(1, 1, 1), Array(1, 1, 1), Array(1, 1, 1))
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
      ProbStrategy(seed, currentHandValue, handValue, history),
      Hand.getHand(handValue)
    )
  }

  private def getSum(handValue: Int): Int = {
    history(handValue).sum
  }

  override def study(win: Boolean): ProbStrategy = {
    val history = Array(Array(1, 1, 1), Array(1, 1, 1), Array(1, 1, 1))
    System.arraycopy(this.history, 0, history, 0, this.history.length)
    val result =
      ProbStrategy(seed, prevHandValue, currentHandValue, history)
    if (win) result.history(prevHandValue)(currentHandValue) += 1
    else {
      result.history(prevHandValue)((currentHandValue + 1) % 3) += 1
      result.history(prevHandValue)((currentHandValue + 2) % 3) += 1
    }
    result
  }
}
