package title4.application.util;

import static title4.application.util.constant.Constant.FACTORY_PROPERTIES_FILE;

import java.util.Hashtable;

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
