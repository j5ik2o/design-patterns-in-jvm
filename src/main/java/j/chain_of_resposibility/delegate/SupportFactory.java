package j.chain_of_resposibility.delegate;

import org.jetbrains.annotations.NotNull;

public class SupportFactory {
    public static Support createNoSupport(@NotNull String name, Support next) {
        return new NoSupport(name, next);
    }

    public static Support createLimitSupport(@NotNull String name, int limit, Support next) {
        return new LimitSupport(name, next, limit);
    }

    public static Support createLimitSupport(@NotNull String name, int limit) {
        return new LimitSupport(name, limit);
    }

    public static Support createOddSupport(@NotNull String name, Support next) {
        return new OddSupport(name, next);
    }

    public static Support createSpecialSupport(@NotNull String name, int number, Support next) {
        return new SpecialSupport(name, next, number);
    }
}
