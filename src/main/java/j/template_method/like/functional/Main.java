package j.template_method.like.functional;

public final class Main {
    public static void main(String[] args) {
        Display d1 = DisplayFactory.createChar('H');
        Display d2 = DisplayFactory.createString("Hello, world.");

        d1.display();
        d2.display();
    }
}
