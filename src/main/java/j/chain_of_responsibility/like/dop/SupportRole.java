package j.chain_of_responsibility.like.dop;

import j.chain_of_responsibility.Trouble;

public final class SupportRole {
  public static void support(SupportData self, Trouble trouble) {
    if (resolve(self, trouble)) {
      done(self, trouble);
    } else if (self.next() != null) {
      support(self.next(), trouble);
    } else {
      fail(trouble);
    }
  }

  private static boolean resolve(SupportData self, Trouble trouble) {
    return switch (self) {
      case SupportData.NoSupportData ignore -> false;
      case SupportData.OddSupportData ignore -> trouble.getNumber() % 2 == 1;
      case SupportData.LimitSupportData limitSupport -> trouble.getNumber() < limitSupport.limit();
      case SupportData.SpecialSupportData specialSupport -> trouble.getNumber()
          == specialSupport.number();
    };
  }

  private static void done(SupportData self, Trouble trouble) {
    System.out.println(trouble + " is resolved by [" + self.name() + "].");
  }

  private static void fail(Trouble trouble) {
    System.out.println(trouble + " cannot be resolved.");
  }
}
