package j.chain_of_resposibility.like.functional;

import j.chain_of_resposibility.Trouble;

public final class MessagePrinter {
  static void done(String name, Trouble trouble) {
    System.out.println(trouble + " is resolved by [" + name + "].");
  }

  static void fail(Trouble trouble) {
    System.out.println(trouble + " cannot be resolved.");
  }
}
