package title7.networking.tcp.client;

import static title7.networking.util.NetworkingConstant.SERVER_IP;
import static title7.networking.util.NetworkingConstant.TCP_SERVER_PORT;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {

  private ObjectInputStream objectInput = null;
  private ObjectOutputStream objectOutput = null;
  private Socket socket = null;
  private final Scanner scanner = new Scanner(System.in);

  public void RequestService() throws IOException {
    try {
      socket = new Socket(SERVER_IP, TCP_SERVER_PORT);

      System.out.print("Escribe una cadena en minúsculas: ");
      objectOutput = new ObjectOutputStream(socket.getOutputStream()); //enmascaro la salida de objeto a bytes
      objectOutput.writeObject(scanner.nextLine()); //escribo objeto de salida (request)

      objectInput = new ObjectInputStream(socket.getInputStream()); //enmascaro la entrada de bytes a objeto
      logInfo((String) objectInput.readObject());

    } catch (Exception exception) {
      throw new RuntimeException("error to connect to TCP server: " + exception.getMessage());
    } finally {
      if (objectInput != null) objectInput.close();
      if (objectOutput != null) objectOutput.close();
      if (socket != null) socket.close();
    }
  }

  public static void main(String[] args) throws IOException {
    new TcpClient().RequestService();
  }

  private static void logInfo(String message) {
    System.out.println("[INFO TCP CLIENT RESPONSE]: " + message);
  }
}
