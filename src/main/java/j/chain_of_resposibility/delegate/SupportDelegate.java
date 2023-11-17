package j.chain_of_resposibility.delegate;


import j.chain_of_resposibility.Trouble;

public final class SupportDelegate {

    public SupportDelegate() {
    }


    public void support(Support self, Trouble trouble) {
        for (Support obj = self; true; obj = obj.getNext()) {
            if (obj.resolve(trouble)) {
                obj.done(trouble);
                break;
            } else if (obj.getNext() == null) {
                obj.fail(trouble);
                break;
            }
        }
    }

    void done(Support self, Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    void fail(Support self, Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
