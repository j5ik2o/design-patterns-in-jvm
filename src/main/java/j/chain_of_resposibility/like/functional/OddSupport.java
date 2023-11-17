package j.chain_of_resposibility.like.functional;

public final class OddSupport {

    public static Support create(String name) {
        return t -> {
            if (t.getNumber() % 2 == 1) {
                MessagePrinter.done(name, t);
                return ControlBreak.of(t).withControlBreak(true);
            } else {
                return ControlBreak.of(t);
            }
        };
    }

}
