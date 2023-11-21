package j.chain_of_responsibility.delegate.supports;

import j.chain_of_responsibility.Trouble;
import j.chain_of_responsibility.delegate.Resolver;
import j.chain_of_responsibility.delegate.Support;
import j.chain_of_responsibility.delegate.SupportDelegate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OddSupport implements Support {
  private final String name;

  private final SupportDelegate delegate;

  public OddSupport(
      @NotNull String name, @NotNull ResolverImpl resolver, @Nullable SupportDelegate next) {
    this.name = name;
    this.delegate = SupportDelegate.create(toString(), resolver, next);
  }

  public OddSupport(@NotNull String name) {
    this(name, new ResolverImpl(), null);
  }

  public OddSupport(@NotNull String name, @NotNull Support next) {
    this(name, new ResolverImpl(), next.getDelegate());
  }

  @Override
  public void support(@NotNull Trouble trouble) {
    delegate.support(trouble);
  }

  @Override
  public SupportDelegate getDelegate() {
    return delegate;
  }

  @Override
  public String toString() {
    return "[" + name + "]";
  }

  public record ResolverImpl() implements Resolver {
    @Override
    public boolean resolve(Trouble trouble) {
      return trouble.getNumber() % 2 == 1;
    }
  }
}
