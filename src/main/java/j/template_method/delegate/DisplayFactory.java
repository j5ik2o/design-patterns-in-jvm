package j.template_method.delegate;

public final class DisplayFactory {
  public static Display createString(String string) {
    return new Display(new StringDisplayDelegate(string));
  }

  public static Display createChar(char ch) {
    return new Display(new CharDisplayDelegate(ch));
  }
}
