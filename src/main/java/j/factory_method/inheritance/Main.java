package j.factory_method.inheritance;

import j.factory_method.inheritance.framework.Factory;
import j.factory_method.inheritance.idcard.IDCardFactory;

public final class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        var card1 = factory.create("Junichi Kato");
        var card2 = factory.create("Taro Yamada");
        var card3 = factory.create("Hanako Yamada");
        card1.use();
        card2.use();
        card3.use();
    }
}
