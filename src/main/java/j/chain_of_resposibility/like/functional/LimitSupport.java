package j.chain_of_resposibility.like.functional;

public class LimitSupport {
    public static Support create(String name, int limit) {
        return t -> {
            if (t.getNumber() < limit) {
                MessagePrinter.done(name, t);
                return ControlBreak.of(t).withControlBreak(true);
            } else {
                return ControlBreak.of(t);
            }
        };
    }
}
