package j.chain_of_responsibility.like.functions;

import j.chain_of_responsibility.Trouble;

public class Main {
  public static void main(String[] args) {
    var alice = SupportFactory.createNoSupport("Alice");
    var bob = SupportFactory.createLimitSupport("Bob", 100);
    var charlie = SupportFactory.createSpecialSupport("Charlie", 429);
    var diana = SupportFactory.createLimitSupport("Diana", 200);
    var elmo = SupportFactory.createOddSupport("Elmo");
    var fred = SupportFactory.createLimitSupport("Fred", 300);

    var chain = alice.orElse(bob).orElse(charlie).orElse(diana).orElse(elmo).orElse(fred);

    for (int i = 0; i < 500; i += 33) {
      chain.apply(new Trouble(i)).orElse(MessagePrinter::fail);
    }
  }
}
