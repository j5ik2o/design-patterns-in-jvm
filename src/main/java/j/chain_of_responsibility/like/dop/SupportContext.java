package j.chain_of_responsibility.like.dop;

import j.chain_of_responsibility.Trouble;

public final class SupportContext {

    private final SupportData support;

    public SupportContext(SupportData support) {
        this.support = support;
    }

  public void support(Trouble trouble) {
    SupportRole.support(support, trouble);
  }
}
