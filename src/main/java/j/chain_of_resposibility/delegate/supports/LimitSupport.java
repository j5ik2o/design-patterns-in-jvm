package j.chain_of_resposibility.delegate.supports;

import j.chain_of_resposibility.Trouble;
import j.chain_of_resposibility.delegate.Resolver;
import j.chain_of_resposibility.delegate.Support;
import j.chain_of_resposibility.delegate.SupportDelegate;
import org.jetbrains.annotations.NotNull;

public final class LimitSupport implements Support {
  private final String name;
  private final SupportDelegate delegate;

    public LimitSupport(String name, ResolverImpl resolver, SupportDelegate next) {
    this.name = name;
    this.delegate = SupportDelegate.create(toString(), resolver, next);
  }

    public LimitSupport(String name, int limit) {
    this(name, new ResolverImpl(limit), null);
  }

    public LimitSupport(String name, int limit, Support next) {
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

    public record ResolverImpl(int limit) implements Resolver {

    @Override
    public boolean resolve(Trouble trouble) {
      return trouble.getNumber() < limit;
    }
  }
}
