package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;

public class Main {
    public static void main(String[] args) {
        var fred = new LimitSupport("Fred", 300);
        var elmo = new OddSupport("Elmo", fred);
        var diana = new LimitSupport("Diana", elmo, 200);
        var charlie = new SpecialSupport("Charlie", diana, 429);
        var bob = new LimitSupport("Bob", charlie, 100);
        var alice = new NoSupport("Alice", bob);

        // さまざまなトラブル発生
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }
    }
}
