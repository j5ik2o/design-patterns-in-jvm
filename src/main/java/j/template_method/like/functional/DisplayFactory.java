package j.template_method.like.functional;

public final class DisplayFactory {
  public static Display createString(String str) {
    return new Display(
        () -> {
          System.out.print("<<");
          return null;
        },
        () -> {
          System.out.print(str);
          return null;
        },
        () -> {
          System.out.println(">>");
          return null;
        });
  }

  public static Display createChar(char ch) {
    return new Display(
        () -> {
          System.out.print("<<");
          return null;
        },
        () -> {
          System.out.print(ch);
          return null;
        },
        () -> {
          System.out.println(">>");
          return null;
        });
  }
}
