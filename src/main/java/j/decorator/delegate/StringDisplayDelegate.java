package j.decorator.delegate;

public class StringDisplayDelegate implements DisplayDelegate {
    private final String string;

    public StringDisplayDelegate(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.length();
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row != 0) {
            throw new IndexOutOfBoundsException();
        }
        return string;
    }
}
