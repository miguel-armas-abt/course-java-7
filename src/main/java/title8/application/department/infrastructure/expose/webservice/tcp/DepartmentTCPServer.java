package title8.application.department.infrastructure.expose.webservice.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.dao.DepartmentDatabaseDAO;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.properties.NetworkProperties;
import title8.application.infrastructure.properties.TcpServiceNameProperties;
import title8.application.infrastructure.util.ObjectFactory;

/**
 * Cada objeto DepartmentDto será enviado como una representación alfanumérica (toString).
 */
public class DepartmentTCPServer extends Thread {

  private Socket socket;
  private DataInputStream inputStream = null;
  private DataOutputStream outputStream = null;

  public DepartmentTCPServer(Socket socket) {
    this.socket = socket;
  }

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(NetworkProperties.departmentPort);
    Socket actualSocket;

    while (true) {
      actualSocket = serverSocket.accept();
      new DepartmentTCPServer(actualSocket).start(); // instancio un TcpServer por cada cliente que se conecta al socket
      System.out.println("DEPARTMENT TCP SERVER IS RUNNING.");
    }
  }

  public void run() {
    try {
      inputStream = new DataInputStream(socket.getInputStream());
      outputStream = new DataOutputStream(socket.getOutputStream());

      int clientRequest = inputStream.readInt();
      if(clientRequest == TcpServiceNameProperties.numberOfFindAllDepartments) {
        findAll(inputStream, outputStream);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();

    } finally {
      try {
        if (outputStream != null) outputStream.close();
        if (inputStream != null) inputStream.close();
        if (socket != null) socket.close();
      } catch (Exception ex) {
        ex.printStackTrace();
        throw new RuntimeException();
      }
    }
  }

  private void findAll(DataInputStream input, DataOutputStream output) {
    try {
      DepartmentDatabaseDAO departmentDatabaseDAO = (DepartmentDatabaseDAO) ObjectFactory.build(ClassesProperties.departmentDaoClass);
      Collection<DepartmentDto> departmentList = departmentDatabaseDAO.findAll();

      int size = departmentList.size(); //envío el tamaño de la colección al cliente
      output.writeInt(size);

      for (DepartmentDto department : departmentList) {
        output.writeUTF(department.toString()); //envío el toString de cada tupla
      }

    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }

}
