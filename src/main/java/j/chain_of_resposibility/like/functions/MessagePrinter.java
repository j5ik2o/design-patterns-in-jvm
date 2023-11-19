package j.chain_of_resposibility.like.functions;

import j.chain_of_resposibility.Trouble;

public final class MessagePrinter {
    public static void done(String name, Trouble trouble) {
    System.out.println(trouble + " is resolved by [" + name + "].");
  }

    public static void fail(Trouble trouble) {
    System.out.println(trouble + " cannot be resolved.");
  }
}
