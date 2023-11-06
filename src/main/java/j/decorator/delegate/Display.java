package j.decorator.delegate;

public class Display {
    private final DisplayDelegate delegate;

    public Display(DisplayDelegate delegate) {
        this.delegate = delegate;
    }

    public int getColumns() {
        return delegate.getColumns();
    }

    public int getRows() {
        return delegate.getRows();
    }

    public String getRowText(int row) {
        return delegate.getRowText(row);
    }

    void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
