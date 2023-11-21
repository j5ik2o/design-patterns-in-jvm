package j.chain_of_responsibility.delegate;

import j.chain_of_responsibility.Trouble;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SupportDelegate {

  private final String name;

  private final Resolver resolver;
  private final SupportDelegate next;

  private SupportDelegate(String name, @NotNull Resolver resolver, @Nullable SupportDelegate next) {
    this.name = name;
    this.resolver = resolver;
    this.next = next;
  }

  private SupportDelegate(String name, @NotNull Resolver resolver) {
    this(name, resolver, null);
  }

  static SupportDelegate create(String name, @NotNull Resolver resolver) {
    return new SupportDelegate(name, resolver);
  }

  public static SupportDelegate create(
      String name, @NotNull Resolver resolver, @Nullable SupportDelegate next) {
    return new SupportDelegate(name, resolver, next);
  }

  public void support(@NotNull Trouble trouble) {
    if (resolver.resolve(trouble)) {
      done(trouble);
    } else if (next != null) {
      next.support(trouble);
    } else {
      fail(trouble);
    }
  }

  private void done(Trouble trouble) {
    System.out.println(trouble + " is resolved by " + name + ".");
  }

  private void fail(Trouble trouble) {
    System.out.println(trouble + " cannot be resolved.");
  }
}
