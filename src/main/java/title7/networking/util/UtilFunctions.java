package title7.networking.util;

import java.net.InetAddress;
import java.util.stream.Collectors;

public class UtilFunctions {

  /**
   * Programación funcional (Java 8)
   */
  public static String upperCaseConverter(String typedString) {
    String response = typedString.chars()
        .mapToObj(character -> Character.toString((char) character))
        .map(character -> character.equals(character.toLowerCase()) ? character.toUpperCase() : character)
        .collect(Collectors.joining());

    logInfo(response);
    return response;
  }

  public static String getIpServer() {
    try {
      String response = InetAddress.getLocalHost().toString();
      logInfo(response);
      return response;
    } catch (Exception exception) {
      throw new RuntimeException("error to get ip address: " + exception.getMessage());
    }
  }

  public static String add(String firstNumber, String secondNumber) {
    String result = String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
    logInfo("suma = " + result);
    return result;
  }

  public static int add(int firstNumber, int secondNumber) {
    int result = firstNumber + secondNumber;
    logInfo("suma = " + result);
    return firstNumber + secondNumber;
  }

  private static void logInfo(String response) {
    System.out.println("[INFO SERVER RESPONSE]: " + response);
  }

}
