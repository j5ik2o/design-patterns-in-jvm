package j.template_method.inheritance;

public final class StringDisplay extends AbstractDisplay {
  private final String string;
  private final int width;

  // コンストラクタ
  public StringDisplay(String string) {
    this.string = string;
    this.width = string.length();
  }

  @Override
  public void open() {
    printLine();
  }

  @Override
  public void print() {
    System.out.println("|" + string + "|");
  }

  @Override
  public void close() {
    printLine();
  }

  private void printLine() {
    System.out.print("+");
    for (int i = 0; i < width; i++) {
      System.out.print("-");
    }
    System.out.println("+");
  }
}
