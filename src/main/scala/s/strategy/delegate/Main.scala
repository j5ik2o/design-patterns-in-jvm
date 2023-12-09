package s.strategy.delegate

object Main {
  def main(args: Array[String]): Unit = {
    var player1 = Player("Taro", new WinningStrategy())
    var player2 = Player("Hana", new ProbStrategy())
    for (i <- 0 until 10000) {
      val nextHand1Result = player1.nextHand
      player1 = nextHand1Result._1
      val nextHand1 = nextHand1Result._2
      val nextHand2Result = player2.nextHand
      player2 = nextHand2Result._1
      val nextHand2 = nextHand2Result._2
      if (nextHand1.isStrongerThan(nextHand2)) {
        System.out.println("Winner:" + player1)
        player1 = player1.win()
        player2 = player2.lose()
      } else if (nextHand2.isStrongerThan(nextHand1)) {
        System.out.println("Winner:" + player2)
        player1 = player1.lose()
        player2 = player2.win()
      } else {
        System.out.println("Even...")
        player1 = player1.even()
        player2 = player2.even()
      }
    }
    System.out.println("Total result:")
    System.out.println(player1)
    System.out.println(player2)
  }
}
