package title8.application2.server.tcp;

import static title7.networking.util.NetworkingConstant.SERVER_IP;
import static title7.networking.util.NetworkingConstant.SERVER_PORT;

import title8.application2.department.model.DepartmentDto;
import title8.application2.department.util.mapper.DepartmentMapper;
import title8.application2.employee.model.EmployeeDto;
import title8.application2.employee.util.mapper.EmployeeMapper;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Vector;

/**
 * Encapsula los procesos involucrados en la obtención de un servicio.
 * Tendrá tantos métodos estáticos como servicios ofrece el servidor.
 */
public class TcpServiceLocator {

  public static Collection<DepartmentDto> findAllDepartments() {
    Socket socket = null;
    DataOutputStream outputStream = null;
    DataInputStream inputStream = null;

    try {
      socket = new Socket(SERVER_IP, SERVER_PORT);
      outputStream = new DataOutputStream(socket.getOutputStream());
      inputStream = new DataInputStream(socket.getInputStream());

      outputStream.writeInt(1); // envío al servidor el código de servicio 1
      int departmentsNumber = inputStream.readInt(); // recupero del servidor un entero N departamentos que enviará

      Vector<DepartmentDto> departamentos = new Vector<>();
      String serverResponse;

      for (int i = 0; i < departmentsNumber; i++) {
        serverResponse = inputStream.readUTF(); // recupero el i-ésimo String (toString de la tupla i)
        departamentos.add(DepartmentMapper.stringToDepartment(serverResponse));
      }
      return departamentos;

    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();

    } finally {
      try {
        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
        if (socket != null) socket.close();

      } catch (Exception ex) {
        ex.printStackTrace();
        throw new RuntimeException();
      }
    }
  }


  public static Collection<EmployeeDto> findEmployeesByDepartmentCode(int departmentCode) {
    Socket socket = null;
    DataInputStream inputStream = null;
    DataOutputStream outputStream = null;

    try {
      socket = new Socket(SERVER_IP, SERVER_PORT);
      outputStream = new DataOutputStream(socket.getOutputStream());
      inputStream = new DataInputStream(socket.getInputStream());

      outputStream.writeInt(2); // envío al servidor el código de servicio 1
      outputStream.writeUTF(Integer.toString(departmentCode)); // envío al servidor el código de departamento (departmentCode)
      int employeesNumber = inputStream.readInt(); // recuperar del servidor un entero N empleados que enviará

      Vector<EmployeeDto> empleados = new Vector<>();
      String serverResponse;

      for (int i = 0; i < employeesNumber; i++) {
        serverResponse = inputStream.readUTF();
        empleados.add(EmployeeMapper.stringToEmployee(serverResponse));
      }
      return empleados;

    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();

    } finally {
      try {
        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
        if (socket != null) socket.close();

      } catch (Exception ex) {
        ex.printStackTrace();
        throw new RuntimeException();
      }
    }
  }
}

