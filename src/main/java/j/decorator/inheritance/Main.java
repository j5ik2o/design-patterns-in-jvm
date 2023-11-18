package j.decorator.inheritance;

public class Main {

  public static void main(String[] args) {
    Display b1 = Display.ofString("Hello, world.");
    Display b2 = Display.ofSideBorder(b1, '#');
    Display b3 = Display.ofFullBorder(b2);
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
