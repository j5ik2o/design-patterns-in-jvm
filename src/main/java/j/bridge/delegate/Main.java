package j.bridge.delegate;

public class Main {
    public static void main(String[] args) {
        Displaible d1 = new Display(new StringDisplayImpl("Hello, Japan."));
        Displaible d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }
}
