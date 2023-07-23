package title2.poo.date;

import title2.poo.date.models.Date;
import title2.poo.date.formatters.DetailedDateFormatter;
import title2.poo.date.util.UtilFunction;

/**
 * Métodos estáticos
 */
public class StaticMethodApplication {

  public static void main(String[] args) {
    Object[] objectArray = {
        new Date(1,3,1999),
        new DetailedDateFormatter("1/3/1999"),
        new String ("Esto es una cadena"),
        new Integer(34)
    };

    UtilFunction.printObjects(objectArray);
  }
}
