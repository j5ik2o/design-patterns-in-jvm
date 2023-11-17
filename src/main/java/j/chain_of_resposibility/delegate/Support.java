package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;

public interface Support {

    void support(Trouble trouble);

    Support withNext(@NotNull Support next);

    SupportDelegate getDelegate();
}
