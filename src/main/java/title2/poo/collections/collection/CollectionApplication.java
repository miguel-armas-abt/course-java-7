package title2.poo.collections.collection;

import title2.poo.collections.collection.model.GenericCollection;
import java.util.Scanner;

public class CollectionApplication {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese una cadena de caracteres o FIN para terminar: ");
    String typedString = scanner.next();

    GenericCollection<String> collection = new GenericCollection<>(5);
    while (!typedString.equals("FIN")) {
      collection.insert(typedString, 0);
      System.out.print("Ingrese una cadena de caracteres o FIN para terminar: ");
      typedString = scanner.next();
    }

    String actualElement;
    for(int i = 0; i < collection.getLength(); i++) {
      actualElement = collection.findByIndex(i);
      System.out.println(actualElement + " - " + actualElement.length() + " catacteres.");
    }
  }
}
