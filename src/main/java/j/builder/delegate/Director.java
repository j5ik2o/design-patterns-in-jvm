package j.builder.delegate;

import java.io.IOException;

public final class Director {
    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() throws IOException {
        builder.makeTitle("Greeting");
        builder.makeString("一般的なあいさつ");
        builder.makeItems(
                new String[]{
                        "How are you?", "Hello.", "Hi.",
                });
        builder.makeString("時間帯に応じたあいさつ");
        builder.makeItems(
                new String[]{
                        "Good morning.", "Good afternoon.", "Good evening.",
                });
        builder.close();
    }
}
