package title8.application.department.infrastructure.expose.webservice.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import title8.application.department.application.service.DepartmentService;
import title8.application.department.application.service.DepartmentServiceImpl;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.consume.repository.DepartmentRepositoryImpl;
import title8.application.infrastructure.properties.NetworkProperties;
import title8.application.infrastructure.properties.TcpServiceNameProperties;

/**
 * Cada objeto DepartmentDto será enviado como una representación alfanumérica (toString).
 */
public class DepartmentTCPServer extends Thread {

  private final Socket socket;
  private DataInputStream inputStream = null;
  private DataOutputStream outputStream = null;

  public DepartmentTCPServer(Socket socket) {
    this.socket = socket;
  }

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(NetworkProperties.DEPARTMENTS_TCP_SERVICE_PORT);
    Socket actualSocket;
    while (true) {
      actualSocket = serverSocket.accept();
      new DepartmentTCPServer(actualSocket).start(); //por cada conexión con el socket se instancia un nuevo TcpServer
      System.out.println("You have connected to the department's TCP server.");
    }
  }

  public void run() {
    try {
      inputStream = new DataInputStream(socket.getInputStream());
      outputStream = new DataOutputStream(socket.getOutputStream());

      int clientRequest = inputStream.readInt();

      if(clientRequest == TcpServiceNameProperties.DEPARTMENTS_FIND_ALL) {
        findAll(outputStream);
      }

      if(clientRequest == TcpServiceNameProperties.DEPARTMENTS_FIND_BY_CODE) {
        findByCode(inputStream, outputStream);
      }

    } catch (Exception exception) {
      throw new RuntimeException("error to select TCP department service: " + exception.getMessage());

    } finally {
      try {
        if (outputStream != null) outputStream.close();
        if (inputStream != null) inputStream.close();
        if (socket != null) socket.close();
      } catch (Exception exception) {
        throw new RuntimeException("error to close TCP connection: " + exception.getMessage());
      }
    }
  }

  private void findAll(DataOutputStream output) {
    try {
      DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
      Collection<DepartmentDto> departmentList = departmentService.findAll();

      int size = departmentList.size(); //envío el tamaño de la colección al cliente
      output.writeInt(size);

      for (DepartmentDto department : departmentList) {
        output.writeUTF(department.toString()); //envío el toString de cada objeto
      }

    } catch (Exception exception) {
      throw new RuntimeException("error to send department list: " + exception.getMessage());
    }
  }

  private void findByCode(DataInputStream input, DataOutputStream output) {
    try {
      DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
      DepartmentDto department = departmentService.findByCode(Integer.parseInt(input.readUTF())); //lee el department code
      output.writeUTF(department.toString());
    } catch (Exception exception) {
      throw new RuntimeException("error to send department by code: " + exception.getMessage());
    }
  }

}
