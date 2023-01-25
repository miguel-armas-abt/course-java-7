package title4.application.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

  private static final String BASE_FILE_PATH = "./src/main/resources/";

  public static String getProperty(String propertyKey, String fileName) {
    String property = "";
    try {
      FileInputStream inputStream = new FileInputStream(BASE_FILE_PATH.concat(fileName));
      Properties properties = new Properties();
      properties.load(inputStream);
      property = properties.getProperty(propertyKey);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return property;
  }

}
