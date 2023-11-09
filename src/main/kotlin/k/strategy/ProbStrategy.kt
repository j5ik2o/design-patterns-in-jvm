package k.strategy

import java.security.SecureRandom

class ProbStrategy(
    private val prevHandValue: Int = 0,
    private val currentHandValue: Int = 0,
    private val history: List<List<Int>> = listOf(listOf(1, 1, 1), listOf(1, 1, 1), listOf(1, 1, 1))
) : Strategy {
  private val random = SecureRandom()

  override fun nextHand(): Pair<Strategy, Hand> {
    val bet = random.nextInt(getSum(currentHandValue))
    val handValue =
        if (bet < history[currentHandValue][0]) {
          0
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
          1
        } else {
          2
        }
    return Pair(ProbStrategy(currentHandValue, handValue, history), Hand.getHand(handValue))
  }

  private fun getSum(handValue: Int): Int {
    return history[handValue].sum()
  }

  override fun study(win: Boolean): Strategy {
    val history = ArrayList(this.history)
    if (win) {
      history[prevHandValue].toMutableList()[currentHandValue]++
    } else {
      history[prevHandValue].toMutableList()[(currentHandValue + 1) % 3]++
      history[prevHandValue].toMutableList()[(currentHandValue + 2) % 3]++
    }
    return ProbStrategy(prevHandValue, currentHandValue, history)
  }
}
