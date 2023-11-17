package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;

public class LimitSupport implements Support {
    private int limit;
    private final String name;
    private final Support next;
    private final SupportDelegate delegate;

    public LimitSupport(String name, Support next, int limit, SupportDelegate delegate) {
        this.name = name;
        this.next = next;
        this.limit = limit;
        this.delegate = delegate;
    }

    public LimitSupport(String name, int limit) {
        this(name, null, limit, new SupportDelegate());
    }

    public LimitSupport(String name, Support next, int limit) {
        this(name, next, limit, new SupportDelegate());
    }


    @Override
    public boolean resolve(Trouble trouble) {
        return trouble.getNumber() < limit;
    }

    @Override
    public void support(Trouble trouble) {
        delegate.support(this, trouble);
    }

    @Override
    public Support withNext(@NotNull Support next) {
        return SupportFactory.createLimitSupport(name, next, limit);
    }

    @Override
    public Support getNext() {
        return next;
    }

    @Override
    public void done(Trouble trouble) {
        delegate.done(this, trouble);
    }

    @Override
    public void fail(Trouble trouble) {
        delegate.fail(this, trouble);
    }
}
