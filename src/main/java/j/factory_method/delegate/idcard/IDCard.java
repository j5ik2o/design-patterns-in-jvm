package j.factory_method.delegate.idcard;

import j.factory_method.delegate.framework.Product;

public final class IDCard implements Product {
  private final String owner;

  public IDCard(String owner) {
    System.out.println(owner + "のカードを作ります。");
    this.owner = owner;
  }

  @Override
  public void use() {
    System.out.println(owner + "のカードを使います。");
  }

  @Override
  public String toString() {
    return "IDCard{" + "owner='" + owner + '\'' + "}";
  }

  public String getOwner() {
    return owner;
  }
}
