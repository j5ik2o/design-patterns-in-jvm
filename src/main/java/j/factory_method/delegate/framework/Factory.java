package j.factory_method.delegate.framework;

public final class Factory {
  private final FactoryDelegate delegate;

  public Factory(FactoryDelegate delegate) {
    this.delegate = delegate;
  }

  public Product create(String owner) {
    Product p = delegate.createProduct(owner);
    delegate.registerProduct(p);
    return p;
  }
}
