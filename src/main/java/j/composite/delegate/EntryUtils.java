package j.composite.delegate;

public final class EntryUtils {
  public static String getFullName(Entry entry) {
    StringBuilder fullname = new StringBuilder();
    Entry cur = entry;
    do {
      fullname.insert(0, cur.getName());
      fullname.insert(0, "/");
      cur = cur.getParent();
    } while (cur != null);
    return fullname.toString();
  }
}
