package j.adapter.delegate;

public final class Banner {
  private final String string;

  public Banner(String string) {
    this.string = string;
  }

  public void showWithParen() {
    System.out.println("(" + string + ")");
  }

  public void showWithAster() {
    System.out.println("*" + string + "*");
  }
}
