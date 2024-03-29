package j.strategy.delegate;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import j.strategy.Hand;

public final class Player {
  private final String name;
  private final Strategy strategy;
  private final int winCount;
  private final int loseCount;
  private final int gameCount;

  Player(String name, Strategy strategy, int winCount, int loseCount, int gameCount) {
    this.name = name;
    this.strategy = strategy;
    this.winCount = winCount;
    this.loseCount = loseCount;
    this.gameCount = gameCount;
  }

  private Player(String name, Strategy strategy) {
    this(name, strategy, 0, 0, 0);
  }

  public static Player of(
      String name, Strategy strategy, int winCount, int loseCount, int gameCount) {
    return new Player(name, strategy, winCount, loseCount, gameCount);
  }

  public static Player of(String name, Strategy strategy) {
    return new Player(name, strategy);
  }

  public Tuple2<Player, Hand> nextHand() {
    var result = strategy.nextHand();
    return Tuple.of(new Player(name, result._1, winCount, loseCount, gameCount), result._2);
  }

  public Player win() {
    return new Player(name, strategy.study(true), winCount + 1, loseCount, gameCount + 1);
  }

  public Player lose() {
    return new Player(name, strategy.study(false), winCount, loseCount + 1, gameCount + 1);
  }

  public Player even() {
    return new Player(name, strategy, winCount, loseCount, gameCount + 1);
  }

  @Override
  public String toString() {
    return "Player{"
        + "name='"
        + name
        + '\''
        + ", strategy="
        + strategy
        + ", winCount="
        + winCount
        + ", loseCount="
        + loseCount
        + ", gameCount="
        + gameCount
        + '}';
  }
}
