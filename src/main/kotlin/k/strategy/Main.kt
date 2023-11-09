package k.strategy

object Main {
  @JvmStatic
  fun main(args: Array<String>) {
    val player1 = Player("Taro", WinningStrategy())
    val player2 = Player("Hana", ProbStrategy())
    for (i in 0..9999) {
      val nextHand1 = player1.nextHand()
      val nextHand2 = player2.nextHand()
      if (nextHand1.isStrongerThan(nextHand2)) {
        println("Winner:$player1")
        player1.win()
        player2.lose()
      } else if (nextHand2.isStrongerThan(nextHand1)) {
        println("Winner:$player2")
        player1.lose()
        player2.win()
      } else {
        println("Even...")
        player1.even()
        player2.even()
      }
    }
    println("Total result:")
    println(player1)
    println(player2)
  }
}
