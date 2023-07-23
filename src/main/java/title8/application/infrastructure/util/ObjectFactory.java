package title8.application.infrastructure.util;

import java.util.Hashtable;

public class ObjectFactory {

  private static final Hashtable<String, Object> instancesHash = new Hashtable<>();

  public static Object build(String className) {
    try {
      Object object = instancesHash.get(className);
      if (object == null) {
        object = Class.forName(className).newInstance(); //nueva instancia del tipo seleccionado
        instancesHash.put(className, object);
      }
      return object;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }
}
