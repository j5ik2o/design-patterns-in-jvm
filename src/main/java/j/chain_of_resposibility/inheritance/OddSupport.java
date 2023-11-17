package j.chain_of_resposibility.inheritance;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OddSupport extends Support {
    public OddSupport(@NotNull String name, @Nullable Support next) {
        super(name, next);
    }

    public OddSupport(@NotNull String name) {
        this(name, null);
    }

    @Override
    protected Support createSupport(@NotNull String name, @Nullable Support next) {
        return SupportFactory.createOddSupport(name, next);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 == 1;
    }
}