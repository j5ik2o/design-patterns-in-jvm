package j.template_method.delegate;

public final class Display {

  private final DisplayDelegate delegate;

  Display(DisplayDelegate delegate) {
    this.delegate = delegate;
  }

  public void display() {
    delegate.open();
    for (int i = 0; i < 5; i++) {
      delegate.print();
    }
    delegate.close();
  }
}
