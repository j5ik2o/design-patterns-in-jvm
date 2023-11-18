package j.strategy;

import io.vavr.Tuple2;

public interface Strategy {
  Tuple2<Strategy, Hand> nextHand();

  Strategy study(boolean win);
}
