package j.template_method.delegate;

public class CharDisplayDelete implements DisplayDelete {
    private final char ch;

    public CharDisplayDelete(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.print(ch);
    }
}
