package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;

public final class LimitSupport implements Support {
  private final String name;
  private final SupportDelegate delegate;

  LimitSupport(String name, ResolverImpl resolver, SupportDelegate next) {
    this.name = name;
    this.delegate = SupportDelegate.create(toString(), resolver, next);
  }

  LimitSupport(String name, int limit) {
    this(name, new ResolverImpl(limit), null);
  }

  LimitSupport(String name, int limit, Support next) {
    this(name, new ResolverImpl(limit), next.getDelegate());
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

  record ResolverImpl(int limit) implements Resolver {

    @Override
    public boolean resolve(Trouble trouble) {
      return trouble.getNumber() < limit;
    }
  }
}
