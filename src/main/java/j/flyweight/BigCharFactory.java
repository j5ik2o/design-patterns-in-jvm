package j.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class BigCharFactory {
  private final Map<String, BigChar> pool = new ConcurrentHashMap<>();
  private static final BigCharFactory singleton = new BigCharFactory();

  private BigCharFactory() {}

  public static BigCharFactory getInstance() {
    return singleton;
  }

  public BigChar getBigChar(char charName) {
    return pool.getOrDefault(String.valueOf(charName), new BigChar(charName));
  }
}
