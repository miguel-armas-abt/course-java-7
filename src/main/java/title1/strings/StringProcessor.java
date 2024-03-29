package title1.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class StringProcessor {

  /**
   * Este método compara objetos de tipo String. Si dos objetos están almacenados en la misma dirección de memoria,
   * entonces se trata del mismo objeto.
   */
  public boolean compareStrings(String firstString, String secondString) {
    boolean isEquals = false;

    // comparación incorrecta
    if (firstString == secondString) {
      isEquals = true;
      System.out.println("se compararon las direcciones de memoria de los objetos.");
    }

    // comparación correcta
    if (firstString.equals(secondString)) {
      isEquals = true;
      System.out.println("se compararon las estructuras de los objetos.");
    }

    return isEquals;
  }

  /**
   * Este método separa una cadena y devuelve sus elementos en una lista.
   */
  public List<String> splitString(String string) {
    List<String> tokenList = new ArrayList<>();

    // uso de la librería StringTokenizer
    StringTokenizer tokenizer = new StringTokenizer(string, "|");
    String actualToken;
    while (tokenizer.hasMoreElements()) {
      actualToken = tokenizer.nextToken();
      tokenList.add(actualToken);
    }
    System.out.println(tokenList);
    tokenList.clear();

    // uso del método split()
    String[] tokenArray = string.split("[|]");
    tokenList = Arrays.asList(tokenArray);
    System.out.println(tokenList);

    return tokenList;
  }

  /**
   * Este método parsea (cambia el tipo) el objeto de tipo String.
   */
  public void wrapString() {
    String stringFromInteger = Integer.toString(1);
    int integerFromString = Integer.parseInt("1");
    String stringFromDouble = Double.toString(1.0);
    double doubleFromString = Double.parseDouble("1.0");

    // impresión de los tipo de datos
    System.out.println(stringFromInteger.getClass().getSimpleName());
    System.out.println(((Object)integerFromString).getClass().getSimpleName());
    System.out.println(stringFromDouble.getClass().getSimpleName());
    System.out.println(((Object)doubleFromString).getClass().getSimpleName());
  }

  /**
   * Este devuelve una lista con los caracteres que contiene una cadena.
   */
  public char[] getCharacterListFromString(String string) {
    char[] charArray = new char[string.length()];
    for(int i = 0; i < string.length(); i++) {
      char actualCharacter = string.charAt(i);
      charArray[i] = actualCharacter;
    }
    return charArray;
  }

  /**
   * Este método presenta algunos métodos para el tratamiento de cadenas.
   */
  public void othersMethodsForStrings(String string) {
    System.out.println("minúsculas: ".concat(string.toLowerCase()));
    System.out.println("mayúsculas: ".concat(string.toUpperCase()));
    System.out.println("primera ocurrencia: " + string.indexOf('a'));
    System.out.println("última ocurrencia: " + string.lastIndexOf('a'));
    System.out.println("subcadena: ".concat(string.substring(0, 4)));
    System.out.println("empieza con M: " + string.startsWith("M"));
    System.out.println("termina con M: " + string.startsWith("M"));
  }

  /**
   * Este método concatena (une o enlaza) cadenas.
   */
  public String concatenateStrings(String firstString, String secondString) {
    String concatenatedString = "";

    // uso de la librería StringBuffer
    concatenatedString = new StringBuffer().append(firstString).append(secondString).toString();
    System.out.println(concatenatedString);

    // uso del operador +
    concatenatedString = firstString + secondString;
    System.out.println(concatenatedString);

    // uso del método concat()
    concatenatedString = firstString.concat(secondString);
    System.out.println(concatenatedString);

    // cálculo de rendimiento
    this.calculatePerformanceOfStringBufferLibrary(100000);
    this.calculatePerformanceOfOperator(100000);

    return concatenatedString;
  }

  private void calculatePerformanceOfStringBufferLibrary(int iterations) {
    long beforeTime = System.currentTimeMillis();

    StringBuffer buffer = new StringBuffer();
    char actualCharacter;

    for(int i = 0; i < iterations; i++){
      actualCharacter = (char) ('A' + i % ('Z' - 'A' + 1)); // caracteres entre 'A' y 'Z'
      buffer.append(actualCharacter);
    }

    long afterTime = System.currentTimeMillis();
    this.printPerformanceMessage(beforeTime, afterTime);
  }

  private void calculatePerformanceOfOperator(int iterations) {
    long beforeTime = System.currentTimeMillis();

    String actualString = "";
    char actualCharacter;

    for(int i = 0; i < iterations; i++){
      actualCharacter = (char) ('A' + i % ('Z' - 'A' + 1)); // caracteres entre 'A' y 'Z'
      actualString = actualString + actualCharacter;
    }

    long afterTime = System.currentTimeMillis();
    this.printPerformanceMessage(beforeTime, afterTime);
  }

  private void printPerformanceMessage(long beforeTime, long afterTime) {
    System.out.println("La cadena fue concatenada en ".concat(String.valueOf(afterTime - beforeTime)).concat(" mls."));
  }

}

