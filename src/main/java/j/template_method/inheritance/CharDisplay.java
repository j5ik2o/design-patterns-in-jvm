package j.template_method.inheritance;

public final class CharDisplay extends Display {
  private final char ch;

  CharDisplay(char ch) {
    this.ch = ch;
  }

  @Override
  public void open() {
    System.out.print("<<");
  }

  @Override
  public void print() {
    System.out.print(ch);
  }

  @Override
  public void close() {
    System.out.print(ch);
  }
}
