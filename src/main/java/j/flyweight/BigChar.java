/* (C)2022 */
package j.flyweight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    private final char charname;
    private final String fontdata;

    public BigChar(char charname) {
        this.charname = charname;
        String fontdata = null;
        try {
            String filename = "data/" + "big" + charname + ".txt";
            StringBuilder sb = new StringBuilder();
            for (String line : Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }
            fontdata = sb.toString();
        } catch (IOException e) {
            fontdata = charname + "?";
        } finally {
            this.fontdata = fontdata;
        }
    }

    public void print() {
        System.out.print(fontdata);
    }
}
