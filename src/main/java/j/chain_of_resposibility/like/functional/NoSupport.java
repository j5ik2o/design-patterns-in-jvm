package j.chain_of_resposibility.like.functional;

public class NoSupport {

    public static Support create(String name) {
        return ControlBreak::of;
    }
}
