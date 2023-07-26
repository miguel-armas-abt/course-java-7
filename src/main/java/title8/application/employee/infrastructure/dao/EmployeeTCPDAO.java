package title8.application.employee.infrastructure.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Vector;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.employee.infrastructure.mapper.EmployeeMapper;
import title8.application.infrastructure.properties.NetworkProperties;
import title8.application.infrastructure.properties.TcpServiceNameProperties;

/**
 * Encapsula los procesos involucrados en la obtención de un servicio.
 * Tendrá tantos métodos estáticos como servicios ofrece el servidor.
 */
public class EmployeeTCPDAO {

  public static Collection<EmployeeDto> findEmployeesByDepartmentCode(int departmentCode) {
    Socket socket = null;
    DataInputStream inputStream = null;
    DataOutputStream outputStream = null;

    try {
      socket = new Socket(NetworkProperties.serverIp, NetworkProperties.employeePort);
      outputStream = new DataOutputStream(socket.getOutputStream());
      inputStream = new DataInputStream(socket.getInputStream());

      outputStream.writeInt(TcpServiceNameProperties.numberOfFindEmployeesByDepartmentCode); // envío al servidor el código de servicio 1
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
