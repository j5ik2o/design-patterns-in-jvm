package j.template_method.delegate;

public final class Display {
    private final DisplayDelegate opener;
    private final DisplayDelegate printer;
    private final DisplayDelegate closer;

    public Display(DisplayDelegate opener, DisplayDelegate printer, DisplayDelegate closer) {
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
