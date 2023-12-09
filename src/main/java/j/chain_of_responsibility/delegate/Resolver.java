package j.chain_of_responsibility.delegate;

import j.chain_of_responsibility.Trouble;

public interface Resolver {
  boolean resolve(Trouble trouble);
}
