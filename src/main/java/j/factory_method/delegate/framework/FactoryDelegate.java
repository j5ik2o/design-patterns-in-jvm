package j.factory_method.delegate.framework;

public interface FactoryDelegate {
    Product createProduct(String owner);

    void registerProduct(Product product);
}
