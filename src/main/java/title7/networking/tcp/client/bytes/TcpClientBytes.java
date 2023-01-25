package title7.networking.tcp.client.bytes;

import static title7.networking.util.NetworkingConstant.SERVER_IP;
import static title7.networking.util.NetworkingConstant.SERVER_PORT;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpClientBytes {

  private static final int BUFFER_LENGTH = 3;

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    BufferedReader reader = null;
    BufferedWriter writer = null;
    Socket socket = null;

    try {
      System.out.println("TCP CLIENT BYTES IS RUNNING...\n=================================================");

      System.out.print("Type a string: ");
      String typedString = scanner.nextLine();

      socket = new Socket(SERVER_IP, SERVER_PORT); // me conecto al servidor

      // enmascaro la entrada y salida de bytes
      writer = new BufferedWriter(new PrintWriter(socket.getOutputStream()));
      reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      // proceso la request para el servidor
      char bufferSent[] = typedString.toCharArray();
      writer.write(bufferSent);
      writer.flush();

      // proceso la response del servidor
      StringBuffer serverResponse = new StringBuffer();

      int numBytesReceived;
      char bufferReceived[] = new char[BUFFER_LENGTH];
      while ((numBytesReceived = reader.read(bufferReceived)) == BUFFER_LENGTH) {
        serverResponse.append(bufferReceived);
      }

      String response = serverResponse.append(bufferReceived, 0, numBytesReceived).toString();
      System.out.println("The response server is: " + response);

    } catch (Exception ex) {
      ex.printStackTrace();

    } finally {
      if (reader != null) reader.close();
      if (writer != null) writer.close();
      if (socket != null) writer.close();
    }
  }
}

