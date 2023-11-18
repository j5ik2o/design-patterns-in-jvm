package j.strategy.delegate;

import io.vavr.Tuple2;
import j.strategy.Hand;

public interface Strategy {
  Tuple2<Strategy, Hand> nextHand();

  Strategy study(boolean win);
}
