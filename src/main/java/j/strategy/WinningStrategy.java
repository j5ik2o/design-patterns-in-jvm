/* (C)2022 */
package j.strategy;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import java.util.Optional;
import java.util.Random;

public class WinningStrategy implements Strategy {
    private final int seed;
    private final Random random;
    private final boolean won;
    private final Optional<Hand> prevHand;

    public WinningStrategy(int seed, boolean won, Optional<Hand> prevHand) {
        this.seed = seed;
        this.random = new Random(seed);
        this.won = won;
        this.prevHand = prevHand;
    }

    public WinningStrategy(int seed) {
        this(seed, false, Optional.empty());
    }

    @Override
    public Tuple2<Strategy, Hand> nextHand() {
        if (!won) {
            var ph = Hand.getHand(random.nextInt(3));
            var st = new WinningStrategy(seed, won, Optional.of(ph));
            return Tuple.of(st, ph);
        }
        return Tuple.of(this, prevHand.get());
    }

    @Override
    public Strategy study(boolean win) {
        return new WinningStrategy(this.seed, win, prevHand);
    }
}
