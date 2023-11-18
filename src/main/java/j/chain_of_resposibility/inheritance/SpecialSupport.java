package j.chain_of_resposibility.inheritance;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialSupport extends Support {
  private final int number; // この番号だけ解決できる

  public SpecialSupport(@NotNull String name, int number, @Nullable Support next) {
    super(name, next);
    this.number = number;
  }

  public SpecialSupport(@NotNull String name, int number) {
    this(name, number, null);
  }

  @Override
  protected boolean resolve(Trouble trouble) {
    return trouble.getNumber() == number;
  }
}
