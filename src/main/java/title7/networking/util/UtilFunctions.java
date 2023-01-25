package title7.networking.util;

import java.net.InetAddress;
import java.util.stream.Collectors;

public class UtilFunctions {
  public static String upperCaseConverter(String typedString) {
    return typedString.chars()
        .mapToObj(c -> Character.toString((char) c))
        .peek(c -> {
          System.out.println(c.matches("[^a-zA-Z]") ?
              c + " -> Esto es un caracter invalido" :
              (c.equals(c.toLowerCase()) ?
                  c + " -> Se transforma a Mayúscula" :
                  c + " -> Se deja tal como está"));
        })
        .map(c -> c.equals(c.toLowerCase()) ? c.toUpperCase() : c)
        .collect(Collectors.joining());
  }

  public static String sum(String num1, String num2) {
    return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
  }

  public static String getIpServer() {
    try {
      String ip = InetAddress.getLocalHost().toString();
      return "Escuchando en " + ip;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }

  public static int add(int a, int b) {
    return a + b;
  }

}
