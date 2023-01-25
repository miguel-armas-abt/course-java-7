package title7.networking.rmi.client;

import static title7.networking.util.NetworkingConstant.SERVER_IP;
import static title7.networking.util.NetworkingConstant.SERVER_PORT;

import title7.networking.rmi.remoteobject.RemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RmiClient {

  public static void main(String[] args) throws Exception {

    try {
      Scanner scanner = new Scanner(System.in);

      Registry registry = LocateRegistry.getRegistry(SERVER_IP, SERVER_PORT);    // obtengo acceso al rmiregistry del servidor
      RemoteObject remoteObject = (RemoteObject) registry.lookup("remoteObject");   // objeto remoto identificado con la clave "remoteObject"

      System.out.print("RMI CLIENT IS RUNNING...\n=================================================");

      // metodo getIpServer()
      String ipResponse = remoteObject.getIpServer();  // invocación de métodos como cualquier otro objeto
      System.out.println(ipResponse);

      // metodo upperCaseConverter(String)
      System.out.print("Type a string: ");
      String inputString = scanner.nextLine();
      System.out.println("Uppercase sentence: " + remoteObject.upperCaseConverter(inputString));

      // metodo add(int, int)
      System.out.print("\nType first number: ");
      int inputFirstNumber = scanner.nextInt();

      System.out.print("Type first number: ");
      int inputSecondNumber = scanner.nextInt();
      System.out.println("Sum: " + remoteObject.add(inputFirstNumber, inputSecondNumber));

    } catch (Exception exception) {
      System.out.println("Error: " + exception);
    }
  }
}