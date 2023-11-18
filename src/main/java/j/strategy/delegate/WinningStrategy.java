package j.strategy.delegate;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import j.strategy.Hand;
import java.security.SecureRandom;
import org.jetbrains.annotations.Nullable;

public final class WinningStrategy implements Strategy {
  private final SecureRandom random;
  private final boolean won;
  @Nullable private final Hand prevHand;

  WinningStrategy(boolean won, @Nullable Hand prevHand) {
    this.random = new SecureRandom();
    this.won = won;
    this.prevHand = prevHand;
  }

  WinningStrategy() {
    this(false, null);
  }

  @Override
  public Tuple2<Strategy, Hand> nextHand() {
    if (!won) {
      var ph = Hand.getHand(random.nextInt(3));
      var st = new WinningStrategy(won, ph);
      return Tuple.of(st, ph);
    }
    return Tuple.of(this, prevHand);
  }

  @Override
  public Strategy study(boolean win) {
    return new WinningStrategy(win, prevHand);
  }
}
