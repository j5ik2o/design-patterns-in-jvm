package j.builder.inheritance;

import org.junit.jupiter.api.Test;
import org.seasar.util.io.ResourceUtil;

import java.io.IOException;

public class BuilderTest {
    @Test
    public void testText() throws IOException {
        TextBuilder textbuilder = new TextBuilder();
        Director director = new Director(textbuilder);
        director.construct();
        String result = textbuilder.getTextResult();
        System.out.println(result);
    }

    @Test
    public void testHtml() throws IOException {
        var workDir = ResourceUtil.getBuildDir(getClass());
        HTMLBuilder htmlbuilder = new HTMLBuilder(workDir);
        Director director = new Director(htmlbuilder);
        director.construct();
        String filename = htmlbuilder.getHTMLResult();
        System.out.println("HTMLファイル (" + filename + ") が作成されました。");
    }
}

