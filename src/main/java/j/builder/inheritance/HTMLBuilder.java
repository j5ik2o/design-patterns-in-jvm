package j.builder.inheritance;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public final class HTMLBuilder extends Builder {
  private final File workDir;
  private String filename = "untitled.html";
  private final StringBuilder sb = new StringBuilder();

  public HTMLBuilder(File workDir) {
    this.workDir = workDir;
  }

  @Override
  public void makeTitle(String title) {
    filename = title + ".html";
    sb.append("<!DOCTYPE html>\n");
    sb.append("<html>\n");
    sb.append("<head><title>");
    sb.append(title);
    sb.append("</title></head>\n");
    sb.append("<body>\n");
    sb.append("<h1>");
    sb.append(title);
    sb.append("</h1>\n\n");
  }

  @Override
  public void makeString(String str) {
    sb.append("<p>");
    sb.append(str);
    sb.append("</p>\n\n");
  }

  @Override
  public void makeItems(String[] items) {
    sb.append("<ul>\n");
    for (String s : items) {
      sb.append("<li>");
      sb.append(s);
      sb.append("</li>\n");
    }
    sb.append("</ul>\n\n");
  }

  @Override
  public void close() throws IOException {
    var path = new File(workDir, filename);
    sb.append("</body>");
    sb.append("</html>\n");
    Writer writer = new FileWriter(path);
    writer.write(sb.toString());
    writer.close();
  }

  public String getHTMLResult() {
    return new File(workDir, filename).toString();
  }
}
