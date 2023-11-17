package j.chain_of_resposibility.inheritance;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpecialSupport extends Support {
    private int number; // この番号だけ解決できる

    public SpecialSupport(@NotNull String name, @Nullable Support next, int number) {
        super(name, next);
        this.number = number;
    }

    public SpecialSupport(@NotNull String name, int number) {
        this(name, null, number);
    }

    @Override
    protected Support createSupport(@NotNull String name, @Nullable Support next) {
        return SupportFactory.createSpecialSupport(name, next, number);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }
}
