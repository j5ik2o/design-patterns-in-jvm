package j.chain_of_resposibility.delegate;

import org.jetbrains.annotations.NotNull;

public class SupportFactory {
    public static Support createNoSupport(@NotNull String name, Support next) {
        return new NoSupport(name, next);
    }

    public static Support createLimitSupport(@NotNull String name, Support next, int limit) {
        return new LimitSupport(name, next, limit);
    }

    public static Support createOddSupport(@NotNull String name, Support next) {
        return new OddSupport(name, next);
    }
}
