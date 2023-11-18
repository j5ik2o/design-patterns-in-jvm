package j.decorator.delegate;

public final class FullBorderDelegate implements DisplayDelegate {
  private final Display display;

  public FullBorderDelegate(Display display) {
    this.display = display;
  }

  @Override
  public int getColumns() {
    return 1 + display.getColumns() + 1;
  }

  @Override
  public int getRows() {
    return 1 + display.getRows() + 1;
  }

  @Override
  public String getRowText(int row) {
    if (row == 0) {
      return "+" + makeLine('-', display.getColumns()) + "+";
    } else if (row == display.getRows() + 1) {
      return "+" + makeLine('-', display.getColumns()) + "+";
    } else {
      return "|" + display.getRowText(row - 1) + "|";
    }
  }

  private String makeLine(char ch, int count) {
    return String.valueOf(ch).repeat(Math.max(0, count));
  }
}
