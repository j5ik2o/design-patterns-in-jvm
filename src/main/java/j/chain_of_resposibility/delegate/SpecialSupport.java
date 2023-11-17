package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;


public class SpecialSupport implements Support {
    private final String name;
    private final SpecialResolver resolver;
    private final SupportDelegate delegate;

    public SpecialSupport(String name, SpecialSupport.SpecialResolver resolver, SupportDelegate next) {
        this.name = name;
        this.resolver = resolver;
        this.delegate = new SupportDelegate(resolver, next);
    }

    public SpecialSupport(String name, int number) {
        this(name, new SpecialResolver(number), null);
    }

    public SpecialSupport(String name, SupportDelegate next, int number) {
        this(name, new SpecialResolver(number), next);
    }

    @Override
    public void support(Trouble trouble) {
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

    public static class SpecialResolver implements Resolver {

        final int number;

        public SpecialResolver(int number) {
            this.number = number;
        }

        @Override
        public boolean resolve(Trouble trouble) {
            return trouble.getNumber() == number;
        }
    }

}
