package j.builder.delegate;

import java.io.IOException;

public interface Builder {
    void makeTitle(String title);

    void makeString(String str);

    void makeItems(String[] items);

    void close() throws IOException;
}
