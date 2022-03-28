/* (C)2022 */
package j.strategy;

import io.vavr.Tuple2;

public interface Strategy {
    public abstract Tuple2<Strategy, Hand> nextHand();

    public abstract Strategy study(boolean win);
}
