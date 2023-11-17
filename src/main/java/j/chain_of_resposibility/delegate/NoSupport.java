package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;

public final class NoSupport implements Support {
    private final String name;
    private final SupportDelegate delegate;

    NoSupport(String name, ResolverImpl resolver, SupportDelegate next) {
        this.name = name;
        this.delegate = SupportDelegate.create(toString(), resolver, next);
    }

    public NoSupport(@NotNull String name) {
        this(name, new ResolverImpl(), null);
    }

    public NoSupport(@NotNull String name, @NotNull SupportDelegate next) {
        this(name, new ResolverImpl(), next);
    }


    @Override
    public void support(@NotNull Trouble trouble) {
        delegate.support(trouble);
    }

    @Override
    public Support withNext(@NotNull Support next) {
        return SupportFactory.createNoSupport(name, next.getDelegate());
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
            return false;
        }
    }

}