package j.chain_of_responsibility.like.functions;

import j.chain_of_responsibility.Trouble;
import java.util.function.Consumer;

public record ControlBreak(Trouble trouble, boolean controlBreak) {

  public static ControlBreak of(Trouble trouble) {
    return new ControlBreak(trouble, false);
  }

  public ControlBreak withControlBreak(boolean b) {
    return new ControlBreak(trouble, b);
  }

  public void orElse(Consumer<Trouble> consumer) {
    if (!controlBreak) {
      consumer.accept(trouble);
    }
  }
}
