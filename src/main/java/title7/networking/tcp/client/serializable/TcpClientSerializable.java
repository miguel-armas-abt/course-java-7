package title7.networking.tcp.client.serializable;

import static title7.networking.util.NetworkingConstant.SERVER_IP;
import static title7.networking.util.NetworkingConstant.SERVER_PORT;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClientSerializable {

  ObjectInputStream objectInput = null;
  ObjectOutputStream objectOutput = null;
  Socket socket = null;
  Scanner scanner = new Scanner(System.in);

  public void RequestService() throws IOException {
    System.out.println("TCP CLIENT SERIALIZABLE IS RUNNING...\n=================================================");

    try {
      System.out.print("Type a string: ");
      String cadena = scanner.nextLine();

      socket = new Socket(SERVER_IP, SERVER_PORT); // instancio el socket con la direccion ip y el puerto del servidor

      objectOutput = new ObjectOutputStream(socket.getOutputStream()); // enmascaro la salida de objeto a bytes
      objectOutput.writeObject(cadena); // escribo objeto de salida (request)

      objectInput = new ObjectInputStream(socket.getInputStream()); // enmascaro la entrada de bytes a objeto
      String response = (String) objectInput.readObject(); // leo objeto de entrada (response)
      System.out.println("The response server is: " + response);

    } catch (Exception ex) {
      ex.printStackTrace();

    } finally {
      if (objectInput != null) objectInput.close();
      if (objectOutput != null) objectOutput.close();
      if (socket != null) socket.close();
    }
  }

  public static void main(String[] args) throws IOException {
    new TcpClientSerializable().RequestService();
  }
}
