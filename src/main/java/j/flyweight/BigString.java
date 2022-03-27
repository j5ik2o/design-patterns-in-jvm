/* (C)2022 */
package j.flyweight;

import java.util.List;

public class BigString {
    private final List<BigChar> bigChars;

    public BigString(String string) {
        bigChars =
                string.chars()
                        .mapToObj(c -> BigCharFactory.getInstance().getBigChar((char) c))
                        .toList();
    }

    public void print() {
        for (BigChar bc : bigChars) {
            bc.print();
        }
    }
}
