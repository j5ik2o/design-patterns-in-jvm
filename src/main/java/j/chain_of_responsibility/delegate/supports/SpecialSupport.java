package j.chain_of_responsibility.delegate.supports;

import j.chain_of_responsibility.Trouble;
import j.chain_of_responsibility.delegate.Resolver;
import j.chain_of_responsibility.delegate.Support;
import j.chain_of_responsibility.delegate.SupportDelegate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialSupport implements Support {
  private final String name;
  private final SupportDelegate delegate;

  public SpecialSupport(
      @NotNull String name, @NotNull ResolverImpl resolver, @Nullable SupportDelegate next) {
    this.name = name;
    this.delegate = SupportDelegate.create(toString(), resolver, next);
  }

  public SpecialSupport(@NotNull String name, int number) {
    this(name, new ResolverImpl(number), null);
  }

  public SpecialSupport(@NotNull String name, int number, @NotNull Support next) {
    this(name, new ResolverImpl(number), next.getDelegate());
  }

  @Override
  public void support(@NotNull Trouble trouble) {
    System.out.printf("SpecialSupport: name = %s%n", name);
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

  public record ResolverImpl(int number) implements Resolver {

    @Override
    public boolean resolve(Trouble trouble) {
      return trouble.getNumber() == number;
    }
  }
}
