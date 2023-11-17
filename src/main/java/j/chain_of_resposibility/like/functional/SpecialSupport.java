package j.chain_of_resposibility.like.functional;

public final class SpecialSupport {

    public static Support create(String name, int number) {
        return trouble -> {
            if (trouble.getNumber() == number) {
                MessagePrinter.done(name, trouble);
                return ControlBreak.of(trouble).withControlBreak(true);
            } else {
                return ControlBreak.of(trouble);
            }
        };
    }
}
