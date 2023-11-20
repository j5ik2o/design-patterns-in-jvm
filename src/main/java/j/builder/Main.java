package j.builder;

public class Main {
    public static void main(String[] args) {
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
            HTMLBuilder htmlbuilder = new HTMLBuilder();
            Director director = new Director(htmlbuilder);
            director.construct();
            String filename = htmlbuilder.getHTMLResult();
            System.out.println("HTMLファイル" + filename + "が作成されました。");
        } else {
            usage();
            System.exit(0);
        }
    }

    // 使い方を表示する
    public static void usage() {
        System.out.println("Usage: java Main text       テキストで文書作成");
        System.out.println("Usage: java Main html       HTMLファイルで文書作成");
    }
}
