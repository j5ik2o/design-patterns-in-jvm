package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;

public final class LimitSupport implements Support {
    private final String name;
    private final SupportDelegate delegate;

    private final ResolverImpl resolver;

    LimitSupport(String name, ResolverImpl resolver, SupportDelegate next) {
        this.name = name;
        this.resolver = resolver;
        this.delegate = SupportDelegate.create(toString(), resolver, next);
    }

    public LimitSupport(String name, int limit) {
        this(name, new ResolverImpl(limit), null);
    }

    public LimitSupport(String name, SupportDelegate next, int limit) {
        this(name, new ResolverImpl(limit), next);
    }

    @Override
    public void support(@NotNull Trouble trouble) {
        delegate.support(trouble);
    }

    @Override
    public Support withNext(@NotNull Support next) {
        return SupportFactory.createLimitSupport(name, next.getDelegate(), resolver.limit);
    }

    @Override
    public SupportDelegate getDelegate() {
        return delegate;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    record ResolverImpl(int limit) implements Resolver {

        @Override
        public boolean resolve(Trouble trouble) {
            return trouble.getNumber() < limit;
        }
    }
}
