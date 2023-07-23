package title8.application.department.infrastructure.resource.webservice.rmi;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import title8.application.infrastructure.constant.RMIRemoteObjectConstant;
import title8.application.infrastructure.properties.NetworkProperties;

public class DepartmentRMIServer {

  public static void main(String[] args) throws RemoteException {

    DepartmentRemoteObject remoteFacade = new DepartmentRemoteObjectImpl();

    try {
      String ip = InetAddress.getLocalHost().toString();
      System.out.println("Department RMI Server connected: " + ip);
    } catch (Exception ex) {
    }

    Registry registry = LocateRegistry.createRegistry(NetworkProperties.departmentPort);
    registry.rebind(RMIRemoteObjectConstant.DEPARTMENT, remoteFacade);
  }
}
