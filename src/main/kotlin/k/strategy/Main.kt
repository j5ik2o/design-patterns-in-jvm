/* (C)2022 */
package k.strategy

import j.strategy.Player
import j.strategy.ProbStrategy
import j.strategy.WinningStrategy

object Main {
  @JvmStatic
  fun main(args: Array<String>) {
    if (args.size != 2) {
      println("Usage: java Main randomseed1 randomseed2")
      println("Example: java Main 314 15")
      System.exit(0)
    }
    val seed1 = args[0].toInt()
    val seed2 = args[1].toInt()
    val player1 = Player("Taro", WinningStrategy(seed1))
    val player2 = Player("Hana", ProbStrategy(seed2))
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
