package title8.application.employee.infrastructure.expose.webservice.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.employee.infrastructure.dao.EmployeeDatabaseDAO;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.properties.NetworkProperties;
import title8.application.infrastructure.properties.TcpServiceNameProperties;
import title8.application.infrastructure.util.ObjectFactory;

public class EmployeeTCPServer extends Thread {

  private Socket socket;
  private DataInputStream inputStream = null;
  private DataOutputStream outputStream = null;

  public EmployeeTCPServer(Socket socket) {
    this.socket = socket;
  }

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(NetworkProperties.employeePort);
    Socket actualSocket;

    while (true) {
      actualSocket = serverSocket.accept();
      new EmployeeTCPServer(actualSocket).start(); // instancio un TcpServer por cada cliente que se conecta al socket
      System.out.println("EMPLOYEE TCP SERVER IS RUNNING.");
    }
  }

  public void run() {
    try {
      inputStream = new DataInputStream(socket.getInputStream());
      outputStream = new DataOutputStream(socket.getOutputStream());

      int clientRequest = inputStream.readInt();
      if(clientRequest == TcpServiceNameProperties.numberOfFindEmployeesByDepartmentCode) {
        findEmployeesByDepartmentCode(inputStream, outputStream);
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

  private void findEmployeesByDepartmentCode(DataInputStream input, DataOutputStream output) {

    try {
      EmployeeDatabaseDAO employeeDao = (EmployeeDatabaseDAO) ObjectFactory.build(ClassesProperties.employeeDaoClass);

      String clientRequest = input.readUTF(); // obtengo código de departamento
      Collection<EmployeeDto> employeeList = employeeDao.findByDepartmentCode(Integer.parseInt(clientRequest));

      int size = employeeList.size();
      output.writeInt(size);

      for (EmployeeDto employee : employeeList) {
        output.writeUTF(employee.toString());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }

}
