package j.abstract_factory.inheritance.listfactory;

import j.abstract_factory.inheritance.factory.Link;

public class ListLink extends Link {
  public ListLink(String caption, String url) {
    super(caption, url);
  }

  @Override
  public String makeHTML() {
    return "  <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
  }
}
