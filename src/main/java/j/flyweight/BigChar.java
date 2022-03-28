/* (C)2022 */
package j.flyweight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    private final char charName;
    private final String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        String fontdata = null;
        try {
            String filename = "data/big" + charName + ".txt";
            StringBuilder sb = new StringBuilder();
            for (String line : Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }
            fontdata = sb.toString();
        } catch (IOException e) {
            fontdata = charName + "?";
        } finally {
            this.fontData = fontdata;
        }
    }

    public void print() {
        System.out.print(fontData);
    }
}
