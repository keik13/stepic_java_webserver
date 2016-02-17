package com.keik.jwebservice.templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Доработанный мной генератор, работает с более новой версией freemaker
 *
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class PageGenerator {
  private static final String HTML_DIR = "/templates";
  private static final String HOME_DIR = "/";

  private static PageGenerator pageGenerator;
  private final Configuration cfg;

  //заменил деприкейтед пустой констурктор new Configuration()
  private PageGenerator() {
    cfg = new Configuration(new Version(2, 3, 23));
    //добавил строку с загрузкой папки с хтмл, без этого не компилилось
    cfg.setClassForTemplateLoading(this.getClass(), HOME_DIR);
  }

  public static PageGenerator instance() {
    if (pageGenerator == null)
      pageGenerator = new PageGenerator();
    return pageGenerator;
  }

  public String getPage(String filename, Map<String, Object> data) {
    Writer stream = new StringWriter();
    try {
      Template template = cfg.getTemplate(HTML_DIR + File.separator + filename);
      template.process(data, stream);
    } catch (IOException | TemplateException e) {
      e.printStackTrace();
    }
    return stream.toString();
  }
}

