/* (C)2022 */
package j.strategy;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Taro", new WinningStrategy());
        Player player2 = new Player("Hana", new ProbStrategy());
        for (int i = 0; i < 10000; i++) {
            var nextHand1Result = player1.nextHand();
            var nextHand2Result = player2.nextHand();
            player1 = nextHand1Result._1;
            player2 = nextHand2Result._1;
            var nextHand1 = nextHand1Result._2;
            var nextHand2 = nextHand2Result._2;
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + player1);
                player1 = player1.win();
                player2 = player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner:" + player2);
                player1 = player1.lose();
                player2 = player2.win();
            } else {
                System.out.println("Even...");
                player1 = player1.even();
                player2 = player2.even();
            }
        }
        System.out.println("Total result:");
        System.out.println(player1);
        System.out.println(player2);
    }
}
