package j.factory_method.delegate.idcard;

import j.factory_method.delegate.framework.FactoryDelegate;
import j.factory_method.delegate.framework.Product;

public final class IDCardFactoryDelegate implements FactoryDelegate {
  @Override
  public Product createProduct(String owner) {
    return new IDCard(owner);
  }

  @Override
  public void registerProduct(Product product) {
    System.out.println(product + "を登録します。");
  }
}
