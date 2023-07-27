package title7.networking.udp.server;

import static title7.networking.util.NetworkingConstant.UDP_SERVER_PORT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {

  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket(UDP_SERVER_PORT);
    System.out.println("You have connected to UDP server.");
    while (true) {

      byte[] bufferReceived = new byte[256];   //buffer para recibir solicitud del cliente
      DatagramPacket datagram = new DatagramPacket(bufferReceived, bufferReceived.length);
      socket.receive(datagram);

      String request = new String(datagram.getData(), 0, datagram.getLength()); //obtengo la request

      String response = request.toUpperCase();
      byte[] bufferSent = response.getBytes(); //buffer para enviar respuesta

      InetAddress address = datagram.getAddress();
      datagram = new DatagramPacket(bufferSent, bufferSent.length, address, datagram.getPort());
      socket.send(datagram); //envío respuesta
    }
  }
}
