package j.builder.delegate;

import org.junit.jupiter.api.Test;
import org.seasar.util.io.ResourceUtil;

import java.io.IOException;

public class BuilderTest {
    @Test
    public void testText() throws IOException {
        var textbuilder = new TextBuilder();
        var director = new Director(textbuilder);
        director.construct();
        var result = textbuilder.getTextResult();
        System.out.println(result);
    }

    @Test
    public void testHtml() throws IOException {
        var workDir = ResourceUtil.getBuildDir(getClass());
        var htmlbuilder = new HTMLBuilder(workDir);
        var director = new Director(htmlbuilder);
        director.construct();
        var filename = htmlbuilder.getHTMLResult();
        System.out.println("HTMLファイル (" + filename + ") が作成されました。");
    }

}
