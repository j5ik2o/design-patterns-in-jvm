package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;


public class SpecialSupport implements Support {
    private final String name;
    private final Support next;
    private final int number; // この番号だけ解決できる
    private final SupportDelegate delegate;

    public SpecialSupport(String name, Support next, int number, SupportDelegate delegate) {
        this.name = name;
        this.next = next;
        this.number = number;
        this.delegate = delegate;
    }

    public SpecialSupport(String name, int number) {
        this(name, null, number, new SupportDelegate());
    }

    public SpecialSupport(String name, Support next, int number) {
        this(name, next, number, new SupportDelegate());
    }

    @Override
    public boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }

    @Override
    public void support(Trouble trouble) {
        delegate.support(this, trouble);
    }

    @Override
    public Support withNext(@NotNull Support next) {
        return null;
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
