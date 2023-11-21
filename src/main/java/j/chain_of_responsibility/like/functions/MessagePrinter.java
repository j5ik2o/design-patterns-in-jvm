package j.chain_of_responsibility.like.functions;

import j.chain_of_responsibility.Trouble;

public final class MessagePrinter {
  public static void done(String name, Trouble trouble) {
    System.out.println(trouble + " is resolved by [" + name + "].");
  }

  public static void fail(Trouble trouble) {
    System.out.println(trouble + " cannot be resolved.");
  }
}
