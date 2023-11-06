package j.decorator.inheritance;

public class Main {
    private static StringDisplay createStringDisplay(String string) {
        return new StringDisplay(string);
    }

    private static SideBorder createSideBorder(Display display, char ch) {
        return new SideBorder(display, ch);
    }

    private static FullBorder createFullBorder(Display display) {
        return new FullBorder(display);
    }

    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world.");
        Display b2 = new SideBorder(b1, '#');
        Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();

        Display b4 =
                createSideBorder(
                        createFullBorder(
                                createSideBorder(createFullBorder(createStringDisplay("Hello, world.")), '*')),
                        '/');
        b4.show();
    }
}
