package title8.application2.server.rmi.remotefacade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteRmiFacade extends Remote {

  List<String> findByDepartmentCode(int departmentCode) throws RemoteException;

  List<String> findAll() throws RemoteException;;
}
