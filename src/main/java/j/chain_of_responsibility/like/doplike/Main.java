package j.chain_of_responsibility.like.doplike;

import j.chain_of_responsibility.Trouble;

public final class Main {
  public static void main(String[] args) {
    var fred = SupportFactory.createLimitSupport("Fred", 300);
    var elmo = SupportFactory.createOddSupport("Elmo", fred);
    var diana = SupportFactory.createLimitSupport("Diana", 200, elmo);
    var charlie = SupportFactory.createSpecialSupport("Charlie", 429, diana);
    var bob = SupportFactory.createLimitSupport("Bob", 100, charlie);
    var alice = SupportFactory.createNoSupport("Alice", bob);
    var context = new SupportContext(alice);

    for (var i = 0; i < 500; i += 33) {
      context.support(new Trouble(i));
    }
  }
}
