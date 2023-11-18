package j.composite.inheritance;

public abstract class Entry {
    protected Entry parent;

    protected void setParent(Entry parent) {
        this.parent = parent;
    }

    // 名前を得る
    public abstract String getName();

    // サイズを得る
    public abstract int getSize();

    // 一覧を表示する
    public void printList() {
        printList("");
    }

    // prefixを前につけて一覧を表示する
    protected abstract void printList(String prefix);

    // 文字列表現
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    // フルパスを得る
    public String getFullName() {
        StringBuilder fullname = new StringBuilder();
        Entry cur = this;
        do {
            fullname.insert(0, cur.getName());
            fullname.insert(0, "/");
            cur = cur.parent;
        } while (cur != null);
        return fullname.toString();
    }
}
