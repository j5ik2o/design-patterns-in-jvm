package j.chain_of_responsibility.like.dop;

public class SupportFactory {
  public static SupportData createNoSupport(String name, SupportData next) {
    return new SupportData.NoSupportData(name, next);
  }

  public static SupportData createOddSupport(String name, SupportData next) {
    return new SupportData.OddSupportData(name, next);
  }

  public static SupportData createLimitSupport(String name, int limit, SupportData next) {
    return new SupportData.LimitSupportData(name, limit, next);
  }

  public static SupportData createLimitSupport(String name, int limit) {
    return new SupportData.LimitSupportData(name, limit, null);
  }

  public static SupportData createSpecialSupport(String name, int number, SupportData next) {
    return new SupportData.SpecialSupportData(name, number, next);
  }
}
