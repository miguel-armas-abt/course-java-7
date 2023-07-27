package title7.networking.rpc.client;

import static title7.networking.util.NetworkingConstant.SERVER_IP;
import static title7.networking.util.NetworkingConstant.RPC_SERVER_PORT;

import java.util.Scanner;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcClient;

public class RpcClient {

  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      XmlRpcClient client = new XmlRpcClient("http://" + SERVER_IP + ":" + RPC_SERVER_PORT);
      Vector<String> params = new Vector<>(); //parametros de entrada para el RPC server

      System.out.print("Escribe una cadena en minúsculas: ");
      params.addElement(scanner.nextLine());
      logInfo(client.execute("myRpcServer.upperCaseConverter", params).toString());
      params.clear();

      System.out.print("Escribe un número entero: ");
      params.addElement(scanner.nextLine());
      System.out.print("Escribe otro número entero: ");
      params.addElement(scanner.nextLine());
      logInfo("suma = " + client.execute("myRpcServer.sum", params).toString());
      params.clear();

    } catch (Exception exception) {
      throw new RuntimeException("error to connect to RPC Server: " + exception.getMessage());
    }
  }

  private static void logInfo(String message) {
    System.out.println("[INFO RPC CLIENT RESPONSE]: " + message);
  }
}
