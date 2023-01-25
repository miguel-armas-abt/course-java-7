package title8.application2.util;

import title4.application.util.PropertiesReader;
import java.util.Hashtable;

import static title8.application2.util.constant.Constant.FACTORY_PROPERTIES_FILE;

public class Factory {

  private static Hashtable<String, Object> instancesHash = new Hashtable<String, Object>();

  public static Object build(String propertyKey) {
    try {
      Object object = instancesHash.get(propertyKey);
      if (object == null) {
        String className = PropertiesReader.getProperty(propertyKey, FACTORY_PROPERTIES_FILE);
        object = Class.forName(className).newInstance(); // nueva instancia del tipo elegido
        instancesHash.put(className, object);
      }
      return object;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }
}
