package j.decorator.inheritance;

public class Main {

  public static void main(String[] args) {
      Display b1 = DisplayFactory.createString("Hello, world.");
      Display b2 = DisplayFactory.createSideBorder(b1, '#');
      Display b3 = DisplayFactory.createFullBorder(b2);
    b1.show();
    b2.show();
    b3.show();

    var b4 =
            DisplayFactory.createSideBorder(
                    DisplayFactory.createFullBorder(
                            DisplayFactory.createSideBorder(
                                    DisplayFactory.createFullBorder(DisplayFactory.createString("Hello, world.")),
                                    '*')),
            '/');
    b4.show();
  }
}
