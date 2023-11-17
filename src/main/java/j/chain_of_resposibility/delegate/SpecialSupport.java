package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class SpecialSupport implements Support {
    private final String name;
    private final SupportDelegate delegate;

    SpecialSupport(@NotNull String name, @NotNull ResolverImpl resolver, @Nullable SupportDelegate next) {
        this.name = name;
        this.delegate = SupportDelegate.create(toString(), resolver, next);
    }

    public SpecialSupport(@NotNull String name, int number) {
        this(name, new ResolverImpl(number), null);
    }

    public SpecialSupport(@NotNull String name, @NotNull SupportDelegate next, int number) {
        this(name, new ResolverImpl(number), next);
    }

    @Override
    public void support(@NotNull Trouble trouble) {
        delegate.support(trouble);
    }

    @Override
    public Support withNext(@NotNull Support next) {
        return null;
    }

    @Override
    public SupportDelegate getDelegate() {
        return delegate;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    record ResolverImpl(int number) implements Resolver {

        @Override
        public boolean resolve(Trouble trouble) {
            return trouble.getNumber() == number;
        }
    }

}
