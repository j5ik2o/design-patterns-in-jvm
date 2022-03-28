/* (C) 2022 */
package s.strategy

import java.util.{Optional, Random}

class WinningStrategy(
    val seed: Int,
    val won: Boolean,
    val prevHand: Optional[Hand]
) extends Strategy {
  val random = new Random(seed)

  def this(seed: Int) {
    this(seed, false, Optional.empty)
  }

  override def nextHand: (Strategy, Hand) = {
    if (!won) {
      val ph = Hand.getHand(random.nextInt(3))
      val st = new WinningStrategy(seed, won, Optional.of(ph))
      (st, ph)
    } else (this, prevHand.get)
  }

  override def study(win: Boolean) =
    new WinningStrategy(this.seed, win, prevHand)
}
