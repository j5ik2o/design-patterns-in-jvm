package j.chain_of_resposibility.like.functional;

public final class SpecialSupport {

    public static Support create(String name, int number) {
        return t -> {
            if (t.getNumber() == number) {
                MessagePrinter.done(name, t);
                return ControlBreak.of(t).withControlBreak(true);
            } else {
                return ControlBreak.of(t);
            }
        };
    }

}
