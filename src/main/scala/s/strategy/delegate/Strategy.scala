package s.strategy.delegate

import s.strategy.Hand

trait Strategy {
  def nextHand: (Strategy, Hand)
  def study(win: Boolean): Strategy
}
