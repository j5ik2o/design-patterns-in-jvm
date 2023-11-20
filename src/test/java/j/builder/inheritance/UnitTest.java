package j.builder.inheritance;

import org.junit.jupiter.api.Test;

public class UnitTest {
    @Test
    public void testText() {
        TextBuilder textbuilder = new TextBuilder();
        Director director = new Director(textbuilder);
        director.construct();
        String result = textbuilder.getTextResult();
        System.out.println(result);
    }

    @Test
    public void testHtml() {
        HTMLBuilder htmlbuilder = new HTMLBuilder();
        Director director = new Director(htmlbuilder);
        director.construct();
        String filename = htmlbuilder.getHTMLResult();
        System.out.println("HTMLファイル" + filename + "が作成されました。");
    }
}

