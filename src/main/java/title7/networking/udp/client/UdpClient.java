package title7.networking.udp.client;

import static title7.networking.util.NetworkingConstant.SERVER_IP_UDP;
import static title7.networking.util.NetworkingConstant.UDP_SERVER_PORT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Escribe una palabra en minúsculas: ");
    String string = scanner.nextLine();

    byte[] bufferSent = string.getBytes(); //buffer con la request
    InetAddress address = InetAddress.getByAddress(SERVER_IP_UDP);

    DatagramPacket datagram = new DatagramPacket(bufferSent, bufferSent.length, address, UDP_SERVER_PORT);

    DatagramSocket socket = new DatagramSocket();
    socket.send(datagram); //envío el paquete
    socket.receive(datagram); //recibo respuesta

    String response = new String(datagram.getData(), 0, datagram.getLength());
    logInfo(response);
    socket.close();
  }

  private static void logInfo(String message) {
    System.out.println("[INFO UDP CLIENT RESPONSE]: " + message);
  }
}
