package j.template_method.delegate;

public final class Display {
    private final DisplayDelete opener;
    private final DisplayDelete printer;
    private final DisplayDelete closer;

    public Display(DisplayDelete opener, DisplayDelete printer, DisplayDelete closer) {
        this.opener = opener;
        this.printer = printer;
        this.closer = closer;
    }

    public final void display() {
        opener.open();
        for (int i = 0; i < 5; i++) {
            printer.print();
        }
        closer.close();
    }

}
