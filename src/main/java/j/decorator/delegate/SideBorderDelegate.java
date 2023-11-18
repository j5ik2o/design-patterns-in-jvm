package j.decorator.delegate;

public final class SideBorderDelegate implements DisplayDelegate {
  private final Display display;
  private final char borderChar;

  public SideBorderDelegate(Display display, char ch) {
    this.display = display;
    borderChar = ch;
  }

  @Override
  public int getColumns() {
    return 1 + display.getColumns() + 1;
  }

  @Override
  public int getRows() {
    return display.getRows();
  }

  @Override
  public String getRowText(int row) {
    return borderChar + display.getRowText(row) + borderChar;
  }
}
