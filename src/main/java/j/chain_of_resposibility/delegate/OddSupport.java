package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;

public class OddSupport implements Support {
    private final String name;

    private final SupportDelegate delegate;


    OddSupport(String name, ResolverImpl resolver, SupportDelegate next) {
        this.name = name;
        this.delegate = SupportDelegate.create(resolver, next);
    }

    public OddSupport(String name) {
        this(name, new ResolverImpl(), null);
    }

    public OddSupport(String name, SupportDelegate next) {
        this(name, new ResolverImpl(), next);
    }

    @Override
    public void support(Trouble trouble) {
        delegate.support(trouble);
    }

    @Override
    public Support withNext(@NotNull Support next) {
        return SupportFactory.createOddSupport(name, next.getDelegate());
    }

    @Override
    public SupportDelegate getDelegate() {
        return delegate;
    }

    record ResolverImpl() implements Resolver {
        @Override
        public boolean resolve(Trouble trouble) {
            return trouble.getNumber() % 2 == 1;
        }
    }

}
