package j.builder.delegate;

import java.io.IOException;

public final class TextBuilder implements Builder {
    private final StringBuilder sb = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        sb.append("==============================\n");
        sb.append("『");
        sb.append(title);
        sb.append("』\n\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("■");
        sb.append(str);
        sb.append("\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String s : items) {
            sb.append("　・");
            sb.append(s);
            sb.append("\n");
        }
        sb.append("\n");
    }

    @Override
    public void close() throws IOException {
        sb.append("==============================\n");
    }

    public String getTextResult() {
        return sb.toString();
    }
}
