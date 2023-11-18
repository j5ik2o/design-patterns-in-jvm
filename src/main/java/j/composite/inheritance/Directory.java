package j.composite.inheritance;

import java.util.ArrayList;
import java.util.List;

public final class Directory extends Entry {
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
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    public Entry add(Entry entry) {
        directory.add(entry);
        entry.setParent(this);
        return this;
    }
}
