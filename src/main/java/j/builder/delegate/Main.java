package j.builder.delegate;

import org.seasar.util.io.ResourceUtil;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        if (args[0].equals("text")) {
            TextBuilder textbuilder = new TextBuilder();
            Director director = new Director(textbuilder);
            director.construct();
            String result = textbuilder.getTextResult();
            System.out.println(result);
        } else if (args[0].equals("html")) {
            var workDir = ResourceUtil.getResourcePath(Main.class);
            HTMLBuilder htmlbuilder = new HTMLBuilder(new File(workDir));
            Director director = new Director(htmlbuilder);
            director.construct();
            String filename = htmlbuilder.getHTMLResult();
            System.out.println("HTMLファイル" + filename + "が作成されました。");
        } else {
            usage();
            System.exit(0);
        }
    }

    public static void usage() {
        System.out.println("Usage: java Main text       テキストで文書作成");
        System.out.println("Usage: java Main html       HTMLファイルで文書作成");
    }

}
