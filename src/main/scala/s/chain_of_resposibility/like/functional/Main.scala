package s.chain_of_resposibility.like.functional

import s.chain_of_resposibility.Trouble

object Main extends App {
  val alice = NoSupport.create("Alice");
  val bob = LimitSupport.create("Bob", 100);
  val charlie = SpecialSupport.create("Charlie", 429);
  val diana = LimitSupport.create("Diana", 200);
  val elmo = OddSupport.create("Elmo");
  val fred = LimitSupport.create("Fred", 300);

  var chain = alice.orElse(bob).orElse(charlie).orElse(diana).orElse(elmo).orElse(fred);

  for (i <- 0 to 500 by 33) {
    chain.applyOrElse(Trouble(i), MessagePrinter.fail)
  }

}
