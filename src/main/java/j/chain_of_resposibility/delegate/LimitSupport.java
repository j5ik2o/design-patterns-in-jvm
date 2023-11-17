package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;

public class LimitSupport implements Support {
    private final String name;
    private final SupportDelegate delegate;

    private final LimitResolver resolver;

    public LimitSupport(String name, LimitResolver resolver, SupportDelegate next) {
        this.name = name;
        this.resolver = resolver;
        this.delegate = new SupportDelegate(resolver, next);
    }

    public LimitSupport(String name, int limit) {
        this(name, new LimitResolver(limit), null);
    }

    public LimitSupport(String name, SupportDelegate next, int limit) {
        this(name, new LimitResolver(limit), next);
    }

    @Override
    public void support(Trouble trouble) {
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

    public static class LimitResolver implements Resolver {
        int limit;

        public LimitResolver(int limit) {
            this.limit = limit;
        }

        @Override
        public boolean resolve(Trouble trouble) {
            return trouble.getNumber() < limit;
        }
    }
}
