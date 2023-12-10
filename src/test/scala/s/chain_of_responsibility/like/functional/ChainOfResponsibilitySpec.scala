package s.chain_of_responsibility.like.functional

import org.scalatest.freespec.AnyFreeSpec
import s.chain_of_responsibility.Trouble

class ChainOfResponsibilitySpec extends AnyFreeSpec {

  "Chain of Responsibility" - {
    "should work" in {
      val alice = NoSupport.create("Alice");
      val bob = LimitSupport.create("Bob", 100);
      val charlie = SpecialSupport.create("Charlie", 429);
      val diana = LimitSupport.create("Diana", 200);
      val elmo = OddSupport.create("Elmo");
      val fred = LimitSupport.create("Fred", 300);

      val chain =
        alice
          .orElse(bob)
          .orElse(charlie)
          .orElse(diana)
          .orElse(elmo)
          .orElse(fred);

      for (i <- 0 to 500 by 33) {
        chain.applyOrElse(Trouble(i), MessagePrinter.fail)
      }
    }
  }
}
