package j.chain_of_resposibility.inheritance.supports;

import j.chain_of_resposibility.Trouble;
import j.chain_of_resposibility.inheritance.Support;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NoSupport extends Support {

  public NoSupport(@NotNull String name, @Nullable Support next) {
    super(name, next);
  }

  public NoSupport(@NotNull String name) {
    this(name, null);
  }

  @Override
  protected boolean resolve(Trouble trouble) {
    return false;
  }
}
