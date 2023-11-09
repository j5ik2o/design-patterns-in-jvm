package j.strategy;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import java.security.SecureRandom;
import java.util.Optional;

public final class WinningStrategy implements Strategy {
    private final SecureRandom random;
    private final boolean won;
    private final Optional<Hand> prevHand;

    public WinningStrategy(boolean won, Optional<Hand> prevHand) {
        this.random = new SecureRandom();
        this.won = won;
        this.prevHand = prevHand;
    }

    public WinningStrategy() {
        this(false, Optional.empty());
    }

    @Override
    public Tuple2<Strategy, Hand> nextHand() {
        if (!won) {
            var ph = Hand.getHand(random.nextInt(3));
            var st = new WinningStrategy(won, Optional.of(ph));
            return Tuple.of(st, ph);
        }
        return Tuple.of(this, prevHand.get());
    }

    @Override
    public Strategy study(boolean win) {
        return new WinningStrategy(win, prevHand);
    }
}
