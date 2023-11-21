package j.chain_of_responsibility.like.functions;

import j.chain_of_responsibility.Trouble;

import java.util.function.Function;

@FunctionalInterface
public interface Support extends Function<Trouble, ControlBreak> {
  default Support orElse(Support next) {
    return trouble -> {
      ControlBreak result = apply(trouble);
      return result.controlBreak() ? result : next.apply(trouble);
    };
  }
}
