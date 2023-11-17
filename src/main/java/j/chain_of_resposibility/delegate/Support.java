package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;
import org.jetbrains.annotations.NotNull;

public interface Support {
    boolean resolve(Trouble trouble);

    void support(Trouble trouble);

    Support withNext(@NotNull Support next);

    Support getNext();

    void done(Trouble trouble);

    void fail(Trouble trouble);
}
