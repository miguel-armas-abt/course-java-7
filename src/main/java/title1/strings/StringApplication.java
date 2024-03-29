package title1.strings;

/**
 * Manejo de cadenas
 */
public class StringApplication {

  public static void main(String[] args) {
    StringProcessor stringManagement = new StringProcessor();

    System.out.println("***************************** compareStrings");
    boolean isEqual = stringManagement.compareStrings("LORENA".toLowerCase(), "lorena");
    System.out.println(isEqual);

    System.out.println("\n\n***************************** concatenateStrings");
    stringManagement.concatenateStrings("Lorena", "Miguel");

    System.out.println("\n\n***************************** splitString");
    stringManagement.splitString("Lorena|Miguel|Jhunior|Mariela");

    System.out.println("\n\n***************************** wrapString");
    stringManagement.wrapString();

    System.out.println("\n\n***************************** getCharacterListFromString");
    System.out.println(stringManagement.getCharacterListFromString("Mariela"));

    System.out.println("\n\n***************************** othersMethodsForStrings");
    stringManagement.othersMethodsForStrings("Mariela");
  }
}
