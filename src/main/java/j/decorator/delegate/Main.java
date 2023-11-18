package j.decorator.delegate;

public class Main {

  public static void main(String[] args) {
    var b1 = DisplayFactory.createString("Hello, world.");
    var b2 = DisplayFactory.createSideBorder(b1, '#');
    var b3 = DisplayFactory.createFullBorder(b2);
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
