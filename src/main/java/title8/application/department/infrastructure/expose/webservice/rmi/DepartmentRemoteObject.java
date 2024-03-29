package title8.application.department.infrastructure.expose.webservice.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DepartmentRemoteObject extends Remote {

  List<String> findAll() throws RemoteException;
  String findByCode(int code) throws RemoteException;
}
