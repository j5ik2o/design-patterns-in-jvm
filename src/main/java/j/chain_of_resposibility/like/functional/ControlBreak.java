package j.chain_of_resposibility.like.functional;

import j.chain_of_resposibility.Trouble;

import java.util.function.Consumer;

public class ControlBreak {
    private final Trouble trouble;
    private final boolean controlBreak;

    ControlBreak(Trouble trouble, boolean controlBreak) {
        this.trouble = trouble;
        this.controlBreak = controlBreak;
    }

    Trouble getTrouble() {
        return trouble;
    }

    boolean isControlBreak() {
        return controlBreak;
    }

    ControlBreak withControlBreak(boolean value) {
        return new ControlBreak(trouble, value);
    }

    static ControlBreak of(Trouble trouble) {
        return new ControlBreak(trouble, false);
    }

    public void otherwise(Consumer<Trouble> consumer) {
        if (!controlBreak) {
            consumer.accept(trouble);
        }
    }

}
