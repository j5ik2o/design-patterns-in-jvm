package j.template_method.inheritance;

public final class DisplayFactory {
  public static Display createString(String string) {
    return new StringDisplay(string);
  }

  public static Display createChar(char ch) {
    return new CharDisplay(ch);
  }
}
