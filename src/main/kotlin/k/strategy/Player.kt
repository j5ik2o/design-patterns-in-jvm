package k.strategy

class Player(private val name: String, private var strategy: Strategy) {
  private var wincount = 0
  private var losecount = 0
  private var gamecount = 0

  fun nextHand(): Hand {
    val result = strategy.nextHand()
    strategy = result.first
    return result.second
  }

  fun win() {
    strategy = strategy.study(true)
    wincount++
    gamecount++
  }

  fun lose() {
    strategy = strategy.study(false)
    losecount++
    gamecount++
  }

  fun even() {
    gamecount++
  }

  override fun toString(): String {
    return ("[" +
        name +
        ":" +
        gamecount +
        " games, " +
        wincount +
        " win, " +
        losecount +
        " lose" +
        "]")
  }
}
