package j.template_method.like.functions;

import java.util.function.Supplier;

public final class Display {
  private final Supplier<Void> opener;
  private final Supplier<Void> printer;
  private final Supplier<Void> closer;

  public Display(Supplier<Void> opener, Supplier<Void> printer, Supplier<Void> closer) {
    this.opener = opener;
    this.printer = printer;
    this.closer = closer;
  }

  public final void display() {
    opener.get();
    for (int i = 0; i < 5; i++) {
      printer.get();
    }
    closer.get();
  }
}
