package j.abstract_factory.inheritance.factory;

public abstract class Link extends Item {
  protected String url;

  public Link(String caption, String url) {
    super(caption);
    this.url = url;
  }
}
