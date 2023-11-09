package k.strategy

import java.security.SecureRandom

class WinningStrategy(private val won: Boolean = false, private val prevHand: Hand? = null) :
    Strategy {
  private val random = SecureRandom()

  override fun nextHand(): Pair<Strategy, Hand> {
    if (!won) {
      val ph = Hand.getHand(random.nextInt(3))
      val st = WinningStrategy(won, ph)
      return Pair(st, ph)
    }
    return Pair(this, prevHand!!)
  }

  override fun study(win: Boolean): Strategy {
    return WinningStrategy(win, prevHand)
  }
}
