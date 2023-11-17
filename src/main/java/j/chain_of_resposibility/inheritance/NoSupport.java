package j.chain_of_resposibility.inheritance;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NoSupport extends Support {

    public NoSupport(@NotNull String name, @Nullable Support next) {
        super(name, next);
    }

    public NoSupport(@NotNull String name) {
        this(name, null);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        // System.out.printf("NoSupport: name = %s\n", getName());
        return false; // 自分は何も解決しない
    }
}
