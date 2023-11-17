package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OddSupport implements Support {
    private final String name;

    private final SupportDelegate delegate;

    OddSupport(@NotNull String name, @NotNull ResolverImpl resolver, @Nullable SupportDelegate next) {
        this.name = name;
        this.delegate = SupportDelegate.create(toString(), resolver, next);
    }

    public OddSupport(@NotNull String name) {
        this(name, new ResolverImpl(), null);
    }

    public OddSupport(@NotNull String name, @NotNull Support next) {
        this(name, new ResolverImpl(), next.getDelegate());
    }

    @Override
    public void support(@NotNull Trouble trouble) {
        delegate.support(trouble);
    }

    @Override
    public SupportDelegate getDelegate() {
        return delegate;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    record ResolverImpl() implements Resolver {
        @Override
        public boolean resolve(Trouble trouble) {
            return trouble.getNumber() % 2 == 1;
        }
    }

}
