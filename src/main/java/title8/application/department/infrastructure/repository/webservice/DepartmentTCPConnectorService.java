package title8.application.department.infrastructure.repository.webservice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Vector;
import title8.application.department.domain.model.DepartmentDto;
import title8.application.department.infrastructure.mapper.DepartmentMapper;
import title8.application.infrastructure.properties.NetworkProperties;
import title8.application.infrastructure.properties.TcpServiceNameProperties;

/**
 * Encapsula los procesos involucrados en la obtención de un servicio.
 * Tendrá tantos métodos estáticos como servicios ofrece el servidor.
 */
public class DepartmentTCPConnectorService {

  public static Collection<DepartmentDto> findAll() {
    Socket socket = null;
    DataOutputStream outputStream = null;
    DataInputStream inputStream = null;

    try {
      socket = new Socket(NetworkProperties.serverIp, NetworkProperties.departmentPort);
      outputStream = new DataOutputStream(socket.getOutputStream());
      inputStream = new DataInputStream(socket.getInputStream());

      outputStream.writeInt(TcpServiceNameProperties.numberOfFindAllDepartments); // envío al servidor el código de servicio 1
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
}
