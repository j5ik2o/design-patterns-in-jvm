package j.abstract_factory.inheritance;

import j.abstract_factory.inheritance.factory.Factory;
import j.abstract_factory.inheritance.factory.Page;
import org.junit.jupiter.api.Test;

public class AbstractFactoryTest {
    @Test
    public void test_1() {
        String filename = "j.abstract_factory.inheritance/listYahoo.html";
        String classname = "j.abstract_factory.inheritance.listfactory.ListFactory";

        Factory factory = Factory.getFactory(classname);
        Page page = factory.createYahooPage();
        page.output(filename);
    }

    @Test
    public void test_2() {
        String filename = "j.abstract_factory.inheritance/divYahoo.html";
        String classname = "j.abstract_factory.inheritance.divfactory.DivFactory";

        Factory factory = Factory.getFactory(classname);
        Page page = factory.createYahooPage();
        page.output(filename);
    }
}
