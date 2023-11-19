package j.composite.delegate;

import java.util.ArrayList;
import java.util.List;

public final class Directory implements Entry {
  private Entry parent;
  private final String name;
  private final List<Entry> directory;

  public Directory(String name, List<Entry> directory) {
    this.name = name;
    this.directory = directory;
  }

  public Directory(String name) {
    this(name, new ArrayList<>());
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
    int size = 0;
    for (Entry entry : directory) {
      size += entry.getSize();
    }
    return size;
  }

  @Override
  public void printList(String prefix) {
    System.out.println(prefix + "/" + this);
    for (Entry entry : directory) {
      entry.printList(prefix + "/" + name);
    }
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

  public Entry add(Entry entry) {
    directory.add(entry);
    entry.setParent(this);
    return this;
  }
}
