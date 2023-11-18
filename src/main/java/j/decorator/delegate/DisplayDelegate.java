package j.decorator.delegate;

public interface DisplayDelegate {
  int getColumns();

  int getRows();

  String getRowText(int row);
}
