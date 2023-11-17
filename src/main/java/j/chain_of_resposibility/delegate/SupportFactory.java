package j.chain_of_resposibility.delegate;

public class SupportFactory {
    public static Support createNoSupport(String name, Support next) {
        return new NoSupport(name, next);
    }

    public static Support createLimitSupport(String name, Support next, int limit) {
        return new LimitSupport(name, next, limit);
    }

    public static Support createOddSupport(String name, Support next) {
        return new OddSupport(name, next);
    }
}
