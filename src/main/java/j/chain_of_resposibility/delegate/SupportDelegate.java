package j.chain_of_resposibility.delegate;


import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SupportDelegate {

    private final Resolver resolver;
    private final SupportDelegate next;

    private SupportDelegate(@NotNull Resolver resolver, @Nullable SupportDelegate next) {
        this.resolver = resolver;
        this.next = next;
    }

    private SupportDelegate(@NotNull Resolver resolver) {
        this(resolver, null);
    }

    static SupportDelegate create(@NotNull Resolver resolver) {
        return new SupportDelegate(resolver);
    }

    static SupportDelegate create(@NotNull Resolver resolver, @Nullable SupportDelegate next) {
        return new SupportDelegate(resolver, next);
    }

    public void support(@NotNull Trouble trouble) {
        if (resolver.resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    private void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    private void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
