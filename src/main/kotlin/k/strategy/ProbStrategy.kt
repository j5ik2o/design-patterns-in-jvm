/* (C)2022 */
package k.strategy

import java.util.*

class ProbStrategy(
    private val seed: Int,
    private val prevHandValue: Int = 0,
    private val currentHandValue: Int = 0,
    private val history: Array<IntArray> =
        arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
) : Strategy {
  private val random: Random = Random(seed.toLong())

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
    return Pair(ProbStrategy(seed, currentHandValue, handValue, history), Hand.getHand(handValue))
  }

  private fun getSum(handValue: Int): Int {
      return history[handValue].sum()
  }

  override fun study(win: Boolean): Strategy {
    val history = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
    System.arraycopy(this.history, 0, history, 0, this.history.size)
    val result = ProbStrategy(seed, prevHandValue, currentHandValue, history)
    if (win) {
      result.history[prevHandValue][currentHandValue]++
    } else {
      result.history[prevHandValue][(currentHandValue + 1) % 3]++
      result.history[prevHandValue][(currentHandValue + 2) % 3]++
    }
    return result
  }
}
