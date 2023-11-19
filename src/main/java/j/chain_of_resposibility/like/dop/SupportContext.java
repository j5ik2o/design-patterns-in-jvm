package j.chain_of_resposibility.like.dop;

import j.chain_of_resposibility.Trouble;

public record SupportContext(Support support) {

    public void support(Trouble trouble) {
       SupportRole.support(support, trouble);
    }
}
