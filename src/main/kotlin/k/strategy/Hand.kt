package k.strategy

enum class Hand(private val handName: String, private val handValue: Int) {
  ROCK("グー", 0),
  SCISSORS("チョキ", 1),
  PAPER("パー", 2);

  fun isStrongerThan(h: Hand): Boolean {
    return fight(h) == 1
  }

  fun isWeakerThan(h: Hand): Boolean {
    return fight(h) == -1
  }

  private fun fight(h: Hand): Int {
    return if (this == h) {
      0
    } else if ((handValue + 1) % 3 == h.handValue) {
      1
    } else {
      -1
    }
  }

  override fun toString(): String {
    return handName
  }

  companion object {
    private val hands = arrayOf(ROCK, SCISSORS, PAPER)
    fun getHand(handvalue: Int): Hand {
      return hands[handvalue]
    }
  }
}
