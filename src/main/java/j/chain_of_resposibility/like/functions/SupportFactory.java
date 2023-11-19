package j.chain_of_resposibility.like.functions;

public class SupportFactory {
    public static Support createNoSupport(String name) {
        return ControlBreak::of;
    }

    public static Support createOddSupport(String name) {
        return trouble -> {
            if (trouble.getNumber() % 2 == 1) {
                MessagePrinter.done(name, trouble);
                return ControlBreak.of(trouble).withControlBreak(true);
            } else {
                return ControlBreak.of(trouble);
            }
        };
    }

    public static Support createLimitSupport(String name, int limit) {
        return trouble -> {
            if (trouble.getNumber() < limit) {
                MessagePrinter.done(name, trouble);
                return ControlBreak.of(trouble).withControlBreak(true);
            } else {
                return ControlBreak.of(trouble);
            }
        };
    }

    public static Support createSpecialSupport(String name, int number) {
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
