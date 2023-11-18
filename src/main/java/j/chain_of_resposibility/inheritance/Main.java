package j.chain_of_resposibility.inheritance;

import j.chain_of_resposibility.Trouble;

public class Main {
  public static void main(String[] args) {
    var fred = SupportFactory.createLimitSupport("Fred", 300);
    var elmo = SupportFactory.createOddSupport("Elmo", fred);
    var diana = SupportFactory.createLimitSupport("Diana", 200, elmo);
    var charlie = SupportFactory.createSpecialSupport("Charlie", 429, diana);
    var bob = SupportFactory.createLimitSupport("Bob", 100, charlie);
    var alice = SupportFactory.createNoSupport("Alice", bob);

    // さまざまなトラブル発生
    for (int i = 0; i < 500; i += 33) {
      alice.support(new Trouble(i));
    }
  }
}
