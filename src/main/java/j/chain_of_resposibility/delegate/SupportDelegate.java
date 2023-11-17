package j.chain_of_resposibility.delegate;


import j.chain_of_resposibility.Trouble;

public final class SupportDelegate {

    private final Resolver resolver;
    private final SupportDelegate next;

    private SupportDelegate(Resolver resolver, SupportDelegate next) {
        this.resolver = resolver;
        this.next = next;
    }

    private SupportDelegate(Resolver resolver) {
        this(resolver, null);
    }

    static SupportDelegate create(Resolver resolver) {
        return new SupportDelegate(resolver);
    }

    static SupportDelegate create(Resolver resolver, SupportDelegate next) {
        return new SupportDelegate(resolver, next);
    }

    public void support(Trouble trouble) {
        for (SupportDelegate obj = this; true; obj = obj.next) {
            if (resolver.resolve(trouble)) {
                obj.done(trouble);
                break;
            } else if (obj.next == null) {
                obj.fail(trouble);
                break;
            }
        }
    }

    private void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    private void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
