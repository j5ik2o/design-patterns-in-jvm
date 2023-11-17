package j.chain_of_resposibility.like.functional;

import j.chain_of_resposibility.Trouble;

public class Main {
    public static void main(String[] args) {
        var alice = NoSupport.create("Alice");
        var bob = LimitSupport.create("Bob", 100);
        var charlie = SpecialSupport.create("Charlie", 429);
        var diana = LimitSupport.create("Diana", 200);
        var elmo = OddSupport.create("Elmo");
        var fred = LimitSupport.create("Fred", 300);

        var chain = alice.chain(bob).chain(charlie).chain(diana).chain(elmo).chain(fred);

        for (int i = 0; i < 500; i += 33) {
            chain.apply(new Trouble(i)).otherwise(MessagePrinter::fail);
        }
    }
}
