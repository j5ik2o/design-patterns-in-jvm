package j.template_method.delegate;


public final class Main {
    public static void main(String[] args) {
        var d1 = new Display(new CharDisplayDelegate('H'));
        var d2 = new Display(new StringDisplayDelegate("Hello, world."));

        d1.display();
        d2.display();
    }
}
