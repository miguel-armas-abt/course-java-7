package title7.networking.udp.client;

import static title7.networking.util.NetworkingConstant.SERVER_IP_UDP;
import static title7.networking.util.NetworkingConstant.SERVER_PORT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    System.out.println("CLIENT IS RUNNING...\n=================================================");
    System.out.print("Type a string: ");
    String string = scanner.nextLine();

    byte[] bufferSent = string.getBytes(); // buffer con la información a enviar
    InetAddress address = InetAddress.getByAddress(SERVER_IP_UDP);

    DatagramPacket datagram = new DatagramPacket(bufferSent, bufferSent.length, address, SERVER_PORT);

    DatagramSocket socket = new DatagramSocket();
    socket.send(datagram); // envío el paquete
    socket.receive(datagram); // recibo respuesta

    String response = new String(datagram.getData(), 0, datagram.getLength());
    System.out.println("[response from server] is: " + response);
    socket.close();
  }
}
