package j.chain_of_resposibility.inheritance;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpecialSupport extends Support {
    private int number; // この番号だけ解決できる

    public SpecialSupport(@NotNull String name, int number, @Nullable Support next) {
        super(name, next);
        this.number = number;
    }

    public SpecialSupport(@NotNull String name, int number) {
        this(name, number, null);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        // System.out.printf("SpecialSupport: name = %s, number = %d\n", getName(), number);
        return trouble.getNumber() == number;
    }
}
