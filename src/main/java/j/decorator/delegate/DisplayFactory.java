package j.decorator.delegate;

public final class DisplayFactory {

  public static Display createString(String string) {
    return new Display(new StringDisplayDelegate(string));
  }

  public static Display createSideBorder(Display display, char ch) {
    return new Display(new SideBorderDelegate(display, ch));
  }

  public static Display createFullBorder(Display display) {
    return new Display(new FullBorderDelegate(display));
  }
}
