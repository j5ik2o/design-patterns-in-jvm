package j.factory_method.inheritance.idcard;

import j.factory_method.inheritance.framework.Factory;
import j.factory_method.inheritance.framework.Product;

public final class IDCardFactory extends Factory {
  @Override
  protected Product createProduct(String owner) {
    return new IDCard(owner);
  }

  @Override
  protected void registerProduct(Product product) {
    System.out.println(product + "を登録します。");
  }
}
