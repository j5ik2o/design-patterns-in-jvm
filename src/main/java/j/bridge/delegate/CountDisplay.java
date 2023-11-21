package j.bridge.delegate;

public class CountDisplay implements Displaible {
    private final Display display;

    public CountDisplay(DisplayImpl impl) {
        this.display = new Display(impl);
    }

    public void display() {
        display.display();
    }

    public void multiDisplay(int times) {
        display.open();
        for (int i = 0; i < times; i++) {
            display.print();
        }
        display.close();
    }
}