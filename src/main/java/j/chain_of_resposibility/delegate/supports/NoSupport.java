package j.chain_of_resposibility.delegate.supports;

import j.chain_of_resposibility.Trouble;
import j.chain_of_resposibility.delegate.Resolver;
import j.chain_of_resposibility.delegate.Support;
import j.chain_of_resposibility.delegate.SupportDelegate;
import org.jetbrains.annotations.NotNull;

public final class NoSupport implements Support {
  private final String name;
  private final SupportDelegate delegate;

  public NoSupport(String name, ResolverImpl resolver, SupportDelegate next) {
    this.name = name;
    this.delegate = SupportDelegate.create(toString(), resolver, next);
  }

  public NoSupport(@NotNull String name) {
    this(name, new ResolverImpl(), null);
  }

  public NoSupport(@NotNull String name, @NotNull Support next) {
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
      return false;
    }
  }
}
