package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;

public interface Resolver {
  boolean resolve(Trouble trouble);
}
