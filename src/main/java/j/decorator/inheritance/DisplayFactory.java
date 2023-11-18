package j.decorator.inheritance;

public final class DisplayFactory {
    public static Display createString(String string) {
        return new StringDisplay(string);
    }

    public static Display createSideBorder(Display display, char ch) {
        return new SideBorder(display, ch);
    }

    public static Display createFullBorder(Display display) {
        return new FullBorder(display);
    }
}
