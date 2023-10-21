/* (C)2022 */
package j.template_method.inheritance;

public class CharDisplay extends AbstractDisplay {
    private final char ch;

    public CharDisplay(char ch) {
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
