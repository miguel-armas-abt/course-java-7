package title8.application.employee.infrastructure.resource.webservice.rmi;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import title8.application.infrastructure.constant.RMIRemoteObjectConstant;
import title8.application.infrastructure.properties.NetworkProperties;

public class EmployeeRMIServer {

  public static void main(String[] args) throws RemoteException {

    EmployeeRemoteObject remoteFacade = new EmployeeRemoteObjectImpl();

    try {
      String ip = InetAddress.getLocalHost().toString();
      System.out.println("Employee RMI Server connected: " + ip);
    } catch (Exception ex) {
    }

    Registry registry = LocateRegistry.createRegistry(NetworkProperties.employeePort);
    registry.rebind(RMIRemoteObjectConstant.EMPLOYEE, remoteFacade);
  }
}
