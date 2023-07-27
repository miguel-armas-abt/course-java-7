package title7.networking.rmi.client;

import static title7.networking.util.NetworkingConstant.SERVER_IP;
import static title7.networking.util.NetworkingConstant.RMI_SERVER_PORT;

import title7.networking.rmi.server.RemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RmiClient {

  public static void main(String[] args) throws Exception {

    try {
      Scanner scanner = new Scanner(System.in);

      Registry registry = LocateRegistry.getRegistry(SERVER_IP, RMI_SERVER_PORT); //obtengo acceso al rmiregistry del RMI Server
      RemoteObject remoteObject = (RemoteObject) registry.lookup("remoteObject"); //recupero el objeto remoto "remoteObject"

      //puedes invocar a los métodos del objeto remoto
      logInfo(remoteObject.getIpServer());

      System.out.print("Escribe una cadena en minúsculas: ");
      logInfo(remoteObject.upperCaseConverter(scanner.nextLine()));

      System.out.print("Escribe un número entero: ");
      int inputFirstNumber = scanner.nextInt();

      System.out.print("Escribe otro número entero: ");
      int inputSecondNumber = scanner.nextInt();

      logInfo("suma = " + remoteObject.add(inputFirstNumber, inputSecondNumber));

    } catch (Exception exception) {
      throw new RuntimeException("error to connect to RMI Server: " + exception.getMessage());
    }
  }

  private static void logInfo(String message) {
    System.out.println("[INFO RMI CLIENT RESPONSE]: " + message);
  }
}
