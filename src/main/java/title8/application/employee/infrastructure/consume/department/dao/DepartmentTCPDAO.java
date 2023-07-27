package title8.application.employee.infrastructure.consume.department.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Vector;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.employee.infrastructure.consume.department.mapper.DepartmentMapper;
import title8.application.infrastructure.properties.NetworkProperties;
import title8.application.infrastructure.properties.TcpServiceNameProperties;

/**
 * Tendrá tantos métodos estáticos como servicios ofrece el servidor TCP.
 */
public class DepartmentTCPDAO {

  public static Collection<DepartmentDto> findAll() {
    Socket socket = null;
    DataOutputStream outputStream = null;
    DataInputStream inputStream = null;

    try {
      socket = new Socket(NetworkProperties.SERVER_IP, NetworkProperties.DEPARTMENTS_TCP_SERVICE_PORT);
      outputStream = new DataOutputStream(socket.getOutputStream());
      inputStream = new DataInputStream(socket.getInputStream());

      outputStream.writeInt(TcpServiceNameProperties.DEPARTMENTS_FIND_ALL); //envío al servidor el código correspondiente al servicio
      int departmentsNumber = inputStream.readInt(); //recupero del servidor el tamaño de la lista que enviará

      Vector<DepartmentDto> departmentList = new Vector<>();
      String serverResponse;

      for (int i = 0; i < departmentsNumber; i++) {
        serverResponse = inputStream.readUTF(); // recupero cada objeto en formato toString
        departmentList.add(DepartmentMapper.stringToDepartment(serverResponse));
      }
      return departmentList;

    } catch (Exception exception) {
      throw new RuntimeException("error to receive department list: " + exception.getMessage());

    } finally {
      try {
        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
        if (socket != null) socket.close();

      } catch (Exception exception) {
        throw new RuntimeException("error to close TCP connection: " + exception.getMessage());
      }
    }
  }

  public static DepartmentDto findByCode(int departmentCode) {
    Socket socket = null;
    DataOutputStream outputStream = null;
    DataInputStream inputStream = null;

    try {
      socket = new Socket(NetworkProperties.SERVER_IP, NetworkProperties.DEPARTMENTS_TCP_SERVICE_PORT);
      outputStream = new DataOutputStream(socket.getOutputStream());
      inputStream = new DataInputStream(socket.getInputStream());

      outputStream.writeInt(TcpServiceNameProperties.DEPARTMENTS_FIND_BY_CODE);
      outputStream.writeUTF(Integer.toString(departmentCode)); //envio el department code

      String serverResponse = inputStream.readUTF();
      return DepartmentMapper.stringToDepartment(serverResponse);

    } catch (Exception exception) {
      throw new RuntimeException("error to receive department by code: " + exception.getMessage());

    } finally {
      try {
        if (inputStream != null) inputStream.close();
        if (outputStream != null) outputStream.close();
        if (socket != null) socket.close();

      } catch (Exception exception) {
        throw new RuntimeException("error to close TCP connection: " + exception.getMessage());
      }
    }
  }

}
