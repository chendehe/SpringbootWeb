package com.chendehe.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public final class FreeMarkerUtils {

  private FreeMarkerUtils() {
  }

  private static final String moduleName = "dailyReport.ftl";
  private static final Template temp;

  static {
    temp = getTemplate(moduleName);
  }

  private static Template getTemplate(String name) {
    try {
      //Read the corresponding FTL template through the Configuration of FreeMarker
      Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
      // Set where to read the corresponding FTL template file
      cfg.setClassForTemplateLoading(FreeMarkerUtils.class, "/ftl");
      return cfg.getTemplate(name);  // Find the file named name in the template file directory
    } catch (IOException e) {
      throw new RuntimeException("this module is not exist", e);
    }
  }

  static byte[] fprint(Map<String, Object> root) {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
         OutputStreamWriter out = new OutputStreamWriter(baos, "UTF-8")) {

      temp.process(root, out);
      return baos.toByteArray();

    } catch (IOException | TemplateException e) {
      throw new RuntimeException("fprint error", e);
    }
  }

}