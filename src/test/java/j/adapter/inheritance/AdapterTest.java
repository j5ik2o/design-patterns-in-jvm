package j.adapter.inheritance;

import org.junit.jupiter.api.Test;

public class AdapterTest {

  @Test
  public void test() {
    Print p = new PrintBanner("Hello");
    p.printWeak();
    p.printStrong();
  }
}
