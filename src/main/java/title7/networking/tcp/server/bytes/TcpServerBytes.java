package title7.networking.tcp.server.bytes;

import static title7.networking.util.NetworkingConstant.SERVER_PORT;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * El método read intenta leer tantos bytes como el tamaño del buffer y retorna  la cantidad de bytes efectivamente leidos.
 *
 * Itera mientras la cantidad de bytes leídos sea igual al tamaño del buffer, ya que cuando la cantidad leída es menor,
 * significa que se leyó el remanente (el sobrante) y este no alcanzó para llenar el buffer.
 */
public class TcpServerBytes {

  private static final int BUFFER_LENGTH = 3;

  public static void main(String[] args) throws IOException {

    BufferedReader reader = null;
    BufferedWriter writer = null;
    Socket socket = null;
    ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

    while (true) {
      try {
        System.out.println("TCP SERVER BYTES IS RUNNING...\n=================================================");

        socket = serverSocket.accept(); // espero la conexion
        System.out.println("Connected " + socket.getInetAddress());

        // enmascaro la entrada y salida de bytes
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new PrintWriter(socket.getOutputStream()));

        // proceso la request del cliente
        int numBytesReceived;
        char[] bufferReceived = new char[BUFFER_LENGTH];
        StringBuffer clientRequest = new StringBuffer();

        while ((numBytesReceived = reader.read(bufferReceived)) == BUFFER_LENGTH) {
          clientRequest.append(bufferReceived); // concateno cada tanda de caracteres recibidos
        }

        clientRequest.append(bufferReceived, 0, numBytesReceived);
        System.out.println("The client request is: " + clientRequest);

        // proceso la response del servidor
        char[] bufferSent;
        String response = clientRequest.toString().toUpperCase();
        bufferSent = response.toCharArray();
        writer.write(bufferSent);

        writer.flush(); // limpio el buffer

      } catch (Exception ex) {
        ex.printStackTrace();

      } finally {
        if (writer != null) writer.close();
        if (reader != null) reader.close();
        if (socket != null) socket.close();
      }
    }
  }
}

