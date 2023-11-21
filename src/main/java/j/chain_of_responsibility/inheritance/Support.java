package j.chain_of_responsibility.inheritance;

import j.chain_of_responsibility.Trouble;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Support {
  private final String name;
  private final Support next;

  public Support(@NotNull String name, @Nullable Support next) {
    this.name = name;
    this.next = next;
  }

  public String getName() {
    return name;
  }

  public void support(Trouble trouble) {
    if (resolve(trouble)) {
      done(trouble);
    } else if (next != null) {
      next.support(trouble);
    } else {
      fail(trouble);
    }
  }

  @Override
  public String toString() {
    return "[" + name + "]";
  }

  protected abstract boolean resolve(Trouble trouble);

  protected void done(Trouble trouble) {
    System.out.println(trouble + " is resolved by " + this + ".");
  }

  protected void fail(Trouble trouble) {
    System.out.println(trouble + " cannot be resolved.");
  }
}
