package title8.application.employee.infrastructure.resource.webservice.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface EmployeeRemoteObject extends Remote {

  List<String> findByDepartmentCode(int departmentCode) throws RemoteException;

}
