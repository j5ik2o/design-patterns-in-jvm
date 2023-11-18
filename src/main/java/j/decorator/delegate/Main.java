package j.decorator.delegate;

public class Main {

  public static void main(String[] args) {
    var b1 = Display.ofString("Hello, world.");
    var b2 = Display.ofSideBorder(b1, '#');
    var b3 = Display.ofFullBorder(b2);
    b1.show();
    b2.show();
    b3.show();

    var b4 =
        Display.ofSideBorder(
            Display.ofFullBorder(
                Display.ofSideBorder(Display.ofFullBorder(Display.ofString("Hello, world.")), '*')),
            '/');
    b4.show();
  }
}
