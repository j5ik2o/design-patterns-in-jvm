package j.decorator.delegate;

public final class Display {
  private final DisplayDelegate delegate;

  public Display(DisplayDelegate delegate) {
    this.delegate = delegate;
  }

  public static Display ofString(String string) {
    return new Display(new StringDisplayDelegate(string));
  }

  public static Display ofSideBorder(Display display, char ch) {
    return new Display(new SideBorderDelegate(display, ch));
  }

  public static Display ofFullBorder(Display display) {
    return new Display(new FullBorderDelegate(display));
  }

  public int getColumns() {
    return delegate.getColumns();
  }

  public int getRows() {
    return delegate.getRows();
  }

  public String getRowText(int row) {
    return delegate.getRowText(row);
  }

  void show() {
    for (int i = 0; i < getRows(); i++) {
      System.out.println(getRowText(i));
    }
  }
}
