package j.chain_of_resposibility.like.functional;

public final class OddSupport {

  public static Support create(String name) {
    return trouble -> {
      if (trouble.getNumber() % 2 == 1) {
        MessagePrinter.done(name, trouble);
        return ControlBreak.of(trouble).withControlBreak(true);
      } else {
        return ControlBreak.of(trouble);
      }
    };
  }
}
