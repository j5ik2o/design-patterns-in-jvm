package s.strategy.delegate

import s.strategy.Hand

final case class Player(
    name: String,
    strategy: Strategy,
    winCount: Int = 0,
    loseCount: Int = 0,
    gameCount: Int = 0
) {

  def nextHand: (Player, Hand) = {
    val result = strategy.nextHand
    (copy(strategy = result._1), result._2)
  }

  def win(): Player = {
    copy(
      strategy = strategy.study(true),
      winCount = winCount + 1,
      gameCount = gameCount + 1
    )
  }

  def lose(): Player = {
    copy(
      strategy = strategy.study(false),
      loseCount = loseCount + 1,
      gameCount = gameCount + 1
    )
  }

  def even(): Player = {
    copy(gameCount = gameCount + 1)
  }

}
