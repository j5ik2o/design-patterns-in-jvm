package j.composite.inheritance;

import org.junit.jupiter.api.Test;

public class UnitTest {
    @Test
    public void test() {
        Directory rootDir = new Directory("root");

        Directory usrDir = new Directory("usr");
        rootDir.add(usrDir);

        Directory yuki = new Directory("yuki");
        usrDir.add(yuki);

        File file = new File("Composite.java", 100);
        yuki.add(file);
        rootDir.printList();

        System.out.println();
        System.out.println("file = " + file.getFullName());
        System.out.println("yuki = " + yuki.getFullName());
    }
}
