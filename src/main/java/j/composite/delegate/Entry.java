package j.composite.delegate;

public interface Entry {

  void setParent(Entry parent);

  Entry getParent();

  String getName();

  // サイズを得る
  int getSize();

  void printList(String prefix);

  // 一覧を表示する
  void printList();

  String getFullName();
}
