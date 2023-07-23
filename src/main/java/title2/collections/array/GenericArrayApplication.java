package title2.collections.array;

import java.util.Scanner;

public class GenericArrayApplication {

  private final static String CONSTANT_MESSAGE = "Ingrese una cadena de caracteres. Si desea terminar la ejecución del programa ingrese FIN.";

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print(CONSTANT_MESSAGE);
    String typedString = scanner.next();

    GenericArray<String> collection = new GenericArray<>(5);
    while (!typedString.equals("FIN")) {
      collection.insert(typedString, 0);
      System.out.print(CONSTANT_MESSAGE);
      typedString = scanner.next();
    }

    String actualElement;
    for(int i = 0; i < collection.getLength(); i++) {
      actualElement = collection.findByIndex(i);
      System.out.println(actualElement + " - " + actualElement.length() + " catacteres.");
    }
  }
}
