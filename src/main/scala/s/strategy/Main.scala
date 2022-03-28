/* (C) 2022 */
package s.strategy

object Main {
  def main(args: Array[String]): Unit = {
    if (args.length != 2) {
      System.out.println("Usage: java Main randomseed1 randomseed2")
      System.out.println("Example: java Main 314 15")
      System.exit(0)
    }
    val seed1 = args(0).toInt
    val seed2 = args(1).toInt
    val player1 = new Player("Taro", new WinningStrategy(seed1))
    val player2 = new Player("Hana", new ProbStrategy(seed2))
    for (i <- 0 until 10000) {
      val nextHand1 = player1.nextHand
      val nextHand2 = player2.nextHand
      if (nextHand1.isStrongerThan(nextHand2)) {
        System.out.println("Winner:" + player1)
        player1.win()
        player2.lose()
      } else if (nextHand2.isStrongerThan(nextHand1)) {
        System.out.println("Winner:" + player2)
        player1.lose()
        player2.win()
      } else {
        System.out.println("Even...")
        player1.even()
        player2.even()
      }
    }
    System.out.println("Total result:")
    System.out.println(player1)
    System.out.println(player2)
  }
}
