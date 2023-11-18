package j.decorator.inheritance;

public abstract class Display {
  public static Display ofString(String string) {
    return new StringDisplay(string);
  }

  public static Display ofSideBorder(Display display, char ch) {
    return new SideBorder(display, ch);
  }

  public static Display ofFullBorder(Display display) {
    return new FullBorder(display);
  }

  public abstract int getColumns();

  public abstract int getRows();

  public abstract String getRowText(int row);

  public void show() {
    for (int i = 0; i < getRows(); i++) {
      System.out.println(getRowText(i));
    }
  }
}
