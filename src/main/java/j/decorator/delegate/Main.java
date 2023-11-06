package j.decorator.delegate;

public class Main {
    private static Display createStringDisplay(String string) {
        return new Display(new StringDisplayDelegate(string));
    }

    private static Display createSideBorder(Display display, char ch) {
        return new Display(new SideBorderDelegate(display, ch));
    }

    private static Display createFullBorder(Display display) {
        return new Display(new FullBorderDelegate(display));
    }

    public static void main(String[] args) {
        var b1 = createStringDisplay("Hello, world.");
        var b2 = createSideBorder(b1, '#');
        var b3 = createFullBorder(b2);
        b1.show();
        b2.show();
        b3.show();

        var b4 =
                createSideBorder(
                        createFullBorder(
                                createSideBorder(createFullBorder(createStringDisplay("Hello, world.")), '*')),
                        '/');
        b4.show();
    }
}
