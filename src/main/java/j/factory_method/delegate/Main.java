package j.factory_method.delegate;


import j.factory_method.delegate.framework.Factory;
import j.factory_method.delegate.idcard.IDCardFactoryDelegate;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory(new IDCardFactoryDelegate());
        var card1 = factory.create("Junichi Kato");
        var card2 = factory.create("Taro Yamada");
        var card3 = factory.create("Hanako Yamada");
        card1.use();
        card2.use();
        card3.use();
    }
}
