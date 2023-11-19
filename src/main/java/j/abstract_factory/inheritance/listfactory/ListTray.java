package j.abstract_factory.inheritance.listfactory;

import j.abstract_factory.inheritance.factory.Item;
import j.abstract_factory.inheritance.factory.Tray;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<li>\n");
        sb.append(caption);
        sb.append("\n<ul>\n");
        for (Item item : tray) {
            sb.append(item.makeHTML());
        }
        sb.append("</ul>\n");
        sb.append("</li>\n");
        return sb.toString();
    }
}
