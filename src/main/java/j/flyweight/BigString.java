package j.flyweight;

import java.util.List;
import java.util.stream.Collectors;

public class BigString {
    private final List<BigChar> bigChars;

    public BigString(String string) {
        bigChars =
                string
                        .chars()
                        .mapToObj(c -> BigCharFactory.getInstance().getBigChar((char) c))
                        .collect(Collectors.toList());
    }

    public void print() {
        for (BigChar bc : bigChars) {
            bc.print();
        }
    }
}
