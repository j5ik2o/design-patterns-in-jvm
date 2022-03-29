/* (C) 2022 */
package s.strategy

import java.security.SecureRandom
import java.util.Optional

case class WinningStrategy(
    won: Boolean,
    prevHand: Optional[Hand]
) extends Strategy {
  val random = new SecureRandom()

  def this() {
    this(false, Optional.empty)
  }

  override def nextHand: (Strategy, Hand) = {
    if (!won) {
      val ph = Hand.getHand(random.nextInt(3))
      val st = WinningStrategy(won, Optional.of(ph))
      (st, ph)
    } else (this, prevHand.get)
  }

  override def study(win: Boolean): WinningStrategy =
    WinningStrategy(win, prevHand)
}
