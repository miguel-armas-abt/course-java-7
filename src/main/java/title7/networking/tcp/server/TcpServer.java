package title7.networking.tcp.server;

import static title7.networking.util.NetworkingConstant.TCP_SERVER_PORT;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import title7.networking.util.UtilFunctions;

public class TcpServer {

  private final ServerSocket servSocket;

  public TcpServer(int puerto) throws IOException {
    servSocket = new ServerSocket(puerto);
  }

  public void ActivateServer() {
    System.out.println("You have connected to TCP server.");
    while (true) {
      try {
        Socket socket = servSocket.accept();
        Service(socket); //se instancia un thread cuando se conecta un cliente
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  private static void Service(Socket sock) {
    ObjectInputStream objectInput = null;
    ObjectOutputStream objectOutput = null;

    try {
      objectInput = new ObjectInputStream(sock.getInputStream());
      String request = (String) objectInput.readObject();  //leo el objeto de entrada (request)

      objectOutput = new ObjectOutputStream(sock.getOutputStream());
      String response = UtilFunctions.upperCaseConverter(request);
      objectOutput.writeObject(response);   //escribo el objeto de salida (response)

    } catch (Exception exception) {
      throw new RuntimeException("error to receive the request: " + exception.getMessage());
    } finally {
      try {
        if (objectInput != null) objectInput.close();
        if (objectOutput != null) objectOutput.close();
        if (sock != null) sock.close();
      } catch (Exception exception) {
        throw new RuntimeException("error to close TCP connection: " + exception.getMessage());
      }
    }
  }

  public static void main(String[] args) throws IOException {
    new TcpServer(TCP_SERVER_PORT).ActivateServer();
  }
}
