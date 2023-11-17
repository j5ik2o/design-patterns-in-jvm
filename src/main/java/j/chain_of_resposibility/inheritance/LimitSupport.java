package j.chain_of_resposibility.inheritance;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LimitSupport extends Support {
    private int limit; // この番号未満なら解決できる

    public LimitSupport(@NotNull String name, @Nullable Support next, int limit) {
        super(name, next);
        this.limit = limit;
    }

    public LimitSupport(@NotNull String name, int limit) {
        this(name, null, limit);
    }

    @Override
    protected Support createSupport(@NotNull String name, @Nullable Support next) {
        return SupportFactory.createLimitSupport(name, next, limit);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() < limit;
    }
}
