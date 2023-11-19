package j.chain_of_resposibility.like.dop;

public class SupportFactory {
  public static Support createNoSupport(String name, Support next) {
    return new Supports.NoSupport(name, next);
  }

  public static Support createOddSupport(String name, Support next) {
    return new Supports.OddSupport(name, next);
  }

  public static Support createLimitSupport(String name, int limit, Support next) {
    return new Supports.LimitSupport(name, limit, next);
  }

  public static Support createLimitSupport(String name, int limit) {
    return new Supports.LimitSupport(name, limit, null);
  }

  public static Support createSpecialSupport(String name, int number, Support next) {
    return new Supports.SpecialSupport(name, number, next);
  }
}
