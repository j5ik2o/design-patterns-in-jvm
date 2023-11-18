package j.strategy.delegate;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import j.strategy.Hand;
import java.security.SecureRandom;

public final class ProbStrategy implements Strategy {
  private final SecureRandom random;
  private final int prevHandValue;
  private final int currentHandValue;
  private final int[][] history;

  ProbStrategy(int prevHandValue, int currentHandValue, int[][] history) {
    this.random = new SecureRandom();
    this.prevHandValue = prevHandValue;
    this.currentHandValue = currentHandValue;
    this.history = history;
  }

  ProbStrategy() {
    this(
        0,
        0,
        new int[][] {
          {
            1, 1, 1,
          },
          {
            1, 1, 1,
          },
          {
            1, 1, 1,
          },
        });
  }

  @Override
  public Tuple2<Strategy, Hand> nextHand() {
    int bet = random.nextInt(getSum(currentHandValue));
    int handValue;
    if (bet < history[currentHandValue][0]) {
      handValue = 0;
    } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
      handValue = 1;
    } else {
      handValue = 2;
    }
    return Tuple.of(
        new ProbStrategy(this.currentHandValue, handValue, history), Hand.getHand(handValue));
  }

  private int getSum(int handvalue) {
    int sum = 0;
    for (int i = 0; i < 3; i++) {
      sum += history[handvalue][i];
    }
    return sum;
  }

  @Override
  public Strategy study(boolean win) {
    int[][] history = {
      {
        1, 1, 1,
      },
      {
        1, 1, 1,
      },
      {
        1, 1, 1,
      },
    };
    System.arraycopy(this.history, 0, history, 0, this.history.length);
    var result = new ProbStrategy(prevHandValue, currentHandValue, history);
    if (win) {
      result.history[prevHandValue][currentHandValue]++;
    } else {
      result.history[prevHandValue][(currentHandValue + 1) % 3]++;
      result.history[prevHandValue][(currentHandValue + 2) % 3]++;
    }
    return result;
  }
}
