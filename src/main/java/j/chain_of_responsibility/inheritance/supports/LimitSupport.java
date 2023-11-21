package j.chain_of_responsibility.inheritance.supports;

import j.chain_of_responsibility.Trouble;
import j.chain_of_responsibility.inheritance.Support;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LimitSupport extends Support {
  private final int limit; // この番号未満なら解決できる

  public LimitSupport(@NotNull String name, int limit, @Nullable Support next) {
    super(name, next);
    this.limit = limit;
  }

  public LimitSupport(@NotNull String name, int limit) {
    this(name, limit, null);
  }

  @Override
  protected boolean resolve(Trouble trouble) {
    return trouble.getNumber() < limit;
  }
}
