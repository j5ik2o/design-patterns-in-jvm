package j.template_method.inheritance;

public final class Main {
  public static void main(String[] args) {
    var d1 = DisplayFactory.createChar('H');
    var d2 = DisplayFactory.createString("Hello, world.");

    d1.display();
    d2.display();
  }
}
