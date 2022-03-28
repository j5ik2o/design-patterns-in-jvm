/* (C) 2022 */
package s.strategy

import java.util.Random

class ProbStrategy(
    val seed: Int,
    val prevHandValue: Int,
    val currentHandValue: Int,
    val history: Array[Array[Int]]
) extends Strategy {
  private val random = new Random(seed)

  def this(seed: Int) {
    this(
      seed,
      0,
      0,
      Array[Array[Int]](Array(1, 1, 1), Array(1, 1, 1), Array(1, 1, 1))
    )
  }

  override def nextHand: (Strategy, Hand) = {
    val bet = random.nextInt(getSum(currentHandValue))
    var handValue = 0
    if (bet < history(currentHandValue)(0)) handValue = 0
    else if (bet < history(currentHandValue)(0) + history(currentHandValue)(1))
      handValue = 1
    else handValue = 2
    (
      new ProbStrategy(this.seed, this.currentHandValue, handValue, history),
      Hand.getHand(handValue)
    )
  }

  private def getSum(handValue: Int): Int = {
    var sum = 0
    for (i <- 0 until 3) {
      sum += history(handValue)(i)
    }
    sum
  }

  override def study(win: Boolean): Strategy = {
    val history = Array(Array(1, 1, 1), Array(1, 1, 1), Array(1, 1, 1))
    System.arraycopy(this.history, 0, history, 0, this.history.length)
    val result =
      new ProbStrategy(seed, prevHandValue, currentHandValue, history)
    if (win) result.history(prevHandValue)(currentHandValue) += 1
    else {
      result.history(prevHandValue)((currentHandValue + 1) % 3) += 1
      result.history(prevHandValue)((currentHandValue + 2) % 3) += 1
    }
    result
  }
}
