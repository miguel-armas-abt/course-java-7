package title8.application.department.infrastructure.expose.webservice.rmi;

import title8.application.infrastructure.constant.RMIRemoteObjectConstant;
import title8.application.infrastructure.properties.NetworkProperties;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DepartmentRMIServer {

  public static void main(String[] args) throws RemoteException {

    DepartmentRemoteObject departmentRemoteObject = new DepartmentRemoteObjectImpl();
    Registry registry = LocateRegistry.createRegistry(NetworkProperties.DEPARTMENTS_RMI_SERVICE_PORT);
    registry.rebind(RMIRemoteObjectConstant.DEPARTMENT, departmentRemoteObject);
    System.out.println("You have connected to the department's RMI server.");
  }
}
