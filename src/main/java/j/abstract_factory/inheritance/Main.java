package j.abstract_factory.inheritance;

import j.abstract_factory.inheritance.factory.Factory;
import j.abstract_factory.inheritance.factory.Page;

public class Main {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java Main filename.html class.name.of.ConcreteFactory");
      System.out.println("Example 1: java Main listYahoo.html listfactory.ListFactory");
      System.out.println("Example 2: java Main divYahoo.html divfactory.DivFactory");
      System.exit(0);
    }

    String filename = args[0];
    String classname = args[1];

    Factory factory = Factory.getFactory(classname);

    // Page
    Page page = factory.createYahooPage();

    page.output(filename);
  }
}
