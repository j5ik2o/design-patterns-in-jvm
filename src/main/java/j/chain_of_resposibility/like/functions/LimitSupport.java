package j.chain_of_resposibility.like.functions;

public final class LimitSupport {
  public static Support create(String name, int limit) {
    return trouble -> {
      if (trouble.getNumber() < limit) {
        MessagePrinter.done(name, trouble);
        return ControlBreak.of(trouble).withControlBreak(true);
      } else {
        return ControlBreak.of(trouble);
      }
    };
  }
}
