package title7.networking.tcp.server.serializable;

import static title7.networking.util.NetworkingConstant.SERVER_PORT;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerSingleThread {

  private Socket socket = null;
  private ServerSocket servSocket = null;

  public TcpServerSingleThread(int puerto) throws IOException {
    servSocket = new ServerSocket(puerto);
  }

  public void ActivateServer() {
    System.out.println("TCP SERVER SERIALIZABLE SINGLE THREAD, IS RUNNING...");
    System.out.println("=================================================");
    while (true) {
      try {
        socket = servSocket.accept();
        Service(socket); // se instancia un thread cuando se conecta un cliente
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
      String request = (String) objectInput.readObject();  // leo el objeto de entrada (request)
      System.out.println("[request from " + sock.getInetAddress() + "] is: " + request);

      objectOutput = new ObjectOutputStream(sock.getOutputStream());
      String response = request.toUpperCase();
      objectOutput.writeObject(response);   // escribo el objeto de salida (response)
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try {
        if (objectInput != null) objectInput.close();
        if (objectOutput != null) objectOutput.close();
        if (sock != null) sock.close();
        System.out.println("Conexión cerrada\n---------------\n");
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public static void main(String[] args) throws IOException {
    new TcpServerSingleThread(SERVER_PORT).ActivateServer();
  }
}
