/* (C) 2022 */
package s.strategy

class Player(var name: String, var strategy: Strategy) {
  private var wincount = 0
  private var losecount = 0
  private var gamecount = 0

  def nextHand: Hand = {
    val result = strategy.nextHand
    strategy = result._1
    result._2
  }

  def win(): Unit = {
    strategy = strategy.study(true)
    wincount += 1
    gamecount += 1
  }

  def lose(): Unit = {
    strategy = strategy.study(false)
    losecount += 1
    gamecount += 1
  }

  def even(): Unit = {
    gamecount += 1
  }

  override def toString: String =
    "[" + name + ":" + gamecount + " games, " + wincount + " win, " + losecount + " lose" + "]"
}
