package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;

public class OddSupport implements Support {
    private final String name;
    private final Support next;
    private final SupportDelegate delegate;

    public OddSupport(String name, Support next, SupportDelegate delegate) {
        this.name = name;
        this.next = next;
        this.delegate = delegate;
    }

    public OddSupport(String name) {
        this(name, null, new SupportDelegate());
    }

    public OddSupport(String name, Support next) {
        this(name, next, new SupportDelegate());
    }

    @Override
    public boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 == 1;
    }

    @Override
    public void support(Trouble trouble) {
        delegate.support(this, trouble);
    }

    @Override
    public Support withNext(@NotNull Support next) {
        return SupportFactory.createOddSupport(name, next);
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
