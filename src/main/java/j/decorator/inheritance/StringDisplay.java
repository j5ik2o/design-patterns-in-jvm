package j.decorator.inheritance;

public final class StringDisplay extends Display {

  private final String string;

  StringDisplay(String string) {
    this.string = string;
  }

  @Override
  public int getColumns() {
    return string.length();
  }

  @Override
  public int getRows() {
    return 1;
  }

  @Override
  public String getRowText(int row) {
    if (row != 0) {
      throw new IndexOutOfBoundsException();
    }
    return string;
  }
}
