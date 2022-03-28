/* (C)2022 */
package k.strategy

import java.util.*

class WinningStrategy(
    private val seed: Int,
    private val won: Boolean = false,
    private val prevHand: Hand? = null
) : Strategy {
  private val random: Random = Random(seed.toLong())

  override fun nextHand(): Pair<Strategy, Hand> {
    if (!won) {
      val ph = Hand.getHand(random.nextInt(3))
      val st = WinningStrategy(seed, won, ph)
      return Pair(st, ph)
    }
    return Pair(this, prevHand!!)
  }

  override fun study(win: Boolean): Strategy {
    return WinningStrategy(seed, win, prevHand)
  }
}
