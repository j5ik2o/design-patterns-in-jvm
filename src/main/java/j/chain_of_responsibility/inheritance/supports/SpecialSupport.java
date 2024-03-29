package j.chain_of_responsibility.inheritance.supports;

import j.chain_of_responsibility.Trouble;
import j.chain_of_responsibility.inheritance.Support;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialSupport extends Support {
  private final int number;

  public SpecialSupport(@NotNull String name, int number, @Nullable Support next) {
    super(name, next);
    this.number = number;
  }

  SpecialSupport(@NotNull String name, int number) {
    this(name, number, null);
  }

  @Override
  protected boolean resolve(Trouble trouble) {
    return trouble.getNumber() == number;
  }
}
