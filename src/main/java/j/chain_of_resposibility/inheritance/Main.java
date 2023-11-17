package j.chain_of_resposibility.inheritance;

import j.chain_of_resposibility.Trouble;

public class Main {
    public static void main(String[] args) {
        var alice = new NoSupport("Alice");
        var bob = new LimitSupport("Bob", 100);
        var charlie = new SpecialSupport("Charlie", 429);
        var diana = new LimitSupport("Diana", 200);
        var elmo = new OddSupport("Elmo");
        var fred = new LimitSupport("Fred", 300);

        // 連鎖の形成
        var chain = alice.withNext(bob).withNext(charlie).withNext(diana).withNext(elmo).withNext(fred);

        // さまざまなトラブル発生
        for (int i = 0; i < 500; i += 33) {
            chain.support(new Trouble(i));
        }
    }
}
