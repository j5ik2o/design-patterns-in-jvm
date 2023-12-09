package j.abstract_factory.inheritance.listfactory;

import j.abstract_factory.inheritance.factory.Factory;
import j.abstract_factory.inheritance.factory.Link;
import j.abstract_factory.inheritance.factory.Page;
import j.abstract_factory.inheritance.factory.Tray;

public class ListFactory extends Factory {
  @Override
  public Link createLink(String caption, String url) {
    return new ListLink(caption, url);
  }

  @Override
  public Tray createTray(String caption) {
    return new ListTray(caption);
  }

  @Override
  public Page createPage(String title, String author) {
    return new ListPage(title, author);
  }
}
