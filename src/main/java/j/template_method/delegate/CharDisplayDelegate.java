package j.template_method.delegate;

public final class CharDisplayDelegate implements DisplayDelegate {
  private final char ch;

  CharDisplayDelegate(char ch) {
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
