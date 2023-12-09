package s.strategy.delegate

import s.strategy.Hand

import java.security.SecureRandom

final case class WinningStrategy(
    won: Boolean,
    prevHand: Option[Hand]
) extends Strategy {
  val random = new SecureRandom()

  def this() = {
    this(false, None)
  }

  override def nextHand: (Strategy, Hand) = {
    if (!won) {
      val ph = Hand.getHand(random.nextInt(3))
      val st = WinningStrategy(won, Some(ph))
      (st, ph)
    } else (this, prevHand.get)
  }

  override def study(win: Boolean): WinningStrategy =
    WinningStrategy(win, prevHand)
}
