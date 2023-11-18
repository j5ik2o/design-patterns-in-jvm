package j.chain_of_resposibility.inheritance;

public final class SupportFactory {
  public static Support createNoSupport(String name, Support next) {
    return new NoSupport(name, next);
  }

  public static Support createLimitSupport(String name, int limit, Support next) {
    return new LimitSupport(name, limit, next);
  }

  public static Support createLimitSupport(String name, int limit) {
    return new LimitSupport(name, limit);
  }

  public static Support createSpecialSupport(String name, int number, Support next) {
    return new SpecialSupport(name, number, next);
  }

  public static Support createOddSupport(String name, Support next) {
    return new OddSupport(name, next);
  }
}
