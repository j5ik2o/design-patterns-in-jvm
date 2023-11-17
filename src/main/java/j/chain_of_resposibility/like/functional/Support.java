package j.chain_of_resposibility.like.functional;

import j.chain_of_resposibility.Trouble;

import java.util.function.Function;

@FunctionalInterface
public interface Support extends Function<Trouble, ControlBreak> {
    default Support orElse(Support next) {
        return s -> {
            ControlBreak result = apply(s);
            return result.isControlBreak() ? result : next.apply(s);
        };
    }

}
