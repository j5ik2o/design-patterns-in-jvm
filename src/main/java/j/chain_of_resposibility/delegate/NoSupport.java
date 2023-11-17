package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;

public final class NoSupport implements Support {
    private final String name;
    private final SupportDelegate delegate;

    public NoSupport(String name, NoResolver resolver, SupportDelegate next) {
        this.name = name;
        this.delegate = new SupportDelegate(resolver, next);
    }

    public NoSupport(String name) {
        this(name, new NoSupport.NoResolver(), null);
    }

    public NoSupport(String name, SupportDelegate next) {
        this(name, new NoSupport.NoResolver(), next);
    }


    @Override
    public void support(Trouble trouble) {
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

    public static class NoResolver implements Resolver {
        @Override
        public boolean resolve(Trouble trouble) {
            return false;
        }
    }

}
