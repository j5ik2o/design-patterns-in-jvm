package j.chain_of_resposibility.delegate;

import j.chain_of_resposibility.Trouble;

interface Resolver {
    boolean resolve(Trouble trouble);
}
