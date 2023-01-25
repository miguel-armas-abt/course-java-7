package title8.application2.server.tcp;

import static title7.networking.util.NetworkingConstant.SERVER_PORT;
import static title8.application2.util.constant.Constant.DEPARTMENT_DAO_CLASS;
import static title8.application2.util.constant.Constant.EMPLOYEE_DAO_CLASS;

import title8.application2.department.dao.DepartmentDao;
import title8.application2.department.model.DepartmentDto;
import title8.application2.employee.dao.EmployeeDao;
import title8.application2.employee.model.EmployeeDto;
import title8.application2.util.Factory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

public class TcpServer extends Thread {

  private Socket socket = null;
  private DataInputStream inputStream = null;
  private DataOutputStream outputStream = null;

  public TcpServer(Socket socket) {
    this.socket = socket;
  }

  public static final int OBTENER_TODOS_DEPARTAMENTOS = 1;
  public static final int OBTENER_EMPLEADOS_POR_DEPARTAMENTO = 2;

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
    Socket actualSocket;

    while (true) {
      actualSocket = serverSocket.accept();
      new TcpServer(actualSocket).start(); // instancio un ServerTCP por cada cliente que se conecta al socket
      System.out.println("TCP SERVER IS RUNNING.");
    }
  }

  public void run() {
    try {
      inputStream = new DataInputStream(socket.getInputStream());
      outputStream = new DataOutputStream(socket.getOutputStream());

      int clientRequest = inputStream.readInt();

      switch (clientRequest) {
        case OBTENER_TODOS_DEPARTAMENTOS:
          findAllDepartments(inputStream, outputStream);
          break;
        case OBTENER_EMPLEADOS_POR_DEPARTAMENTO:
          findEmployeesByDepartmentCode(inputStream, outputStream);
          break;
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

  /**
   * Cada String será una representación alfanumérica (toString) de un DTODepartamento.
   */
  private void findAllDepartments(DataInputStream input, DataOutputStream output) {
    try {
      DepartmentDao departmentDao = (DepartmentDao) Factory.build(DEPARTMENT_DAO_CLASS);
      Collection<DepartmentDto> departmentList = departmentDao.findAll();

      int size = departmentList.size(); // envío el size al cliente(tamaño de la colección)
      output.writeInt(size);

      for (DepartmentDto department : departmentList) {
        output.writeUTF(department.toString()); // envío el toString de cada tupla
      }

    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }

  /**
   * Cada String será una representación alfanumérica (toString) de un DTODepartamento.
   */
  private void findEmployeesByDepartmentCode(DataInputStream input, DataOutputStream output) {

    try {
      EmployeeDao employeeDao = (EmployeeDao) Factory.build(EMPLOYEE_DAO_CLASS);

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

