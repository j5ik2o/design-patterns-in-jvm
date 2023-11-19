package j.chain_of_resposibility.like.dop;

import j.chain_of_resposibility.Trouble;

public final class SupportRole {
  public static void support(Support support, Trouble trouble) {
    if (resolve(support, trouble)) {
      done(support, trouble);
    } else if (support.next() != null) {
      support(support.next(), trouble);
    } else {
      fail(trouble);
    }
  }

  private static boolean resolve(Support support, Trouble trouble) {
    return switch (support) {
      case Supports.NoSupport ignore -> false;
      case Supports.OddSupport ignore -> trouble.getNumber() % 2 == 1;
      case Supports.LimitSupport limitSupport -> trouble.getNumber() < limitSupport.limit();
      case Supports.SpecialSupport specialSupport -> trouble.getNumber() == specialSupport.number();
    };
  }

  private static void done(Support support, Trouble trouble) {
    System.out.println(trouble + " is resolved by [" + support.name() + "].");
  }

  private static void fail(Trouble trouble) {
    System.out.println(trouble + " cannot be resolved.");
  }
}
