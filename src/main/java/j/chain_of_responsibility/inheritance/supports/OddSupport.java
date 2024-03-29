package j.chain_of_responsibility.inheritance.supports;

import j.chain_of_responsibility.Trouble;
import j.chain_of_responsibility.inheritance.Support;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OddSupport extends Support {
  public OddSupport(@NotNull String name, @Nullable Support next) {
    super(name, next);
  }

  public OddSupport(@NotNull String name) {
    this(name, null);
  }

  @Override
  protected boolean resolve(Trouble trouble) {
    return trouble.getNumber() % 2 == 1;
  }
}
