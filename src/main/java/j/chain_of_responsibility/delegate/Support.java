package j.chain_of_responsibility.delegate;

import j.chain_of_responsibility.Trouble;
import org.jetbrains.annotations.NotNull;

public interface Support {

  void support(@NotNull Trouble trouble);

  SupportDelegate getDelegate();
}
