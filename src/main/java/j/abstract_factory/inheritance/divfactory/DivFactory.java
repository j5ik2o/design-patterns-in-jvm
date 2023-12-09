package j.abstract_factory.inheritance.divfactory;

import j.abstract_factory.inheritance.factory.Factory;
import j.abstract_factory.inheritance.factory.Link;
import j.abstract_factory.inheritance.factory.Page;
import j.abstract_factory.inheritance.factory.Tray;

public class DivFactory extends Factory {
  @Override
  public Link createLink(String caption, String url) {
    return new DivLink(caption, url);
  }

  @Override
  public Tray createTray(String caption) {
    return new DivTray(caption);
  }

  @Override
  public Page createPage(String title, String author) {
    return new DivPage(title, author);
  }
}
