package j.composite.delegate;

public final class File implements Entry {
  private Entry parent;
  private final String name;
  private final int size;

  public File(String name, int size) {
    this.name = name;
    this.size = size;
  }

  @Override
  public void setParent(Entry parent) {
    this.parent = parent;
  }

  @Override
  public Entry getParent() {
    return parent;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public void printList(String prefix) {
    System.out.println(prefix + "/" + this);
  }

  @Override
  public void printList() {
    printList("");
  }

  @Override
  public String getFullName() {
    return EntryUtils.getFullName(this);
  }

  @Override
  public String toString() {
    return getName() + " (" + getSize() + ")";
  }
}
