package j.factory_method.inheritance.idcard;

import j.factory_method.inheritance.framework.Product;

public final class IDCard extends Product {
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
