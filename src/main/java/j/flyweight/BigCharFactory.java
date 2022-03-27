/* (C)2022 */
package j.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BigCharFactory {
    private final Map<String, BigChar> pool = new ConcurrentHashMap<>();
    private static final BigCharFactory singleton = new BigCharFactory();

    private BigCharFactory() {}

    public static BigCharFactory getInstance() {
        return singleton;
    }

    public BigChar getBigChar(char charname) {
        return pool.getOrDefault(String.valueOf(charname), new BigChar(charname));
    }
}
