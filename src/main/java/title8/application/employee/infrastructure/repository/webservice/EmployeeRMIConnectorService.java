package title8.application.employee.infrastructure.repository.webservice;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import title8.application.infrastructure.properties.NetworkProperties;

public class EmployeeRMIConnectorService {

  public static Object getRemoteObject(String remoteObjectName){
    try{
      Registry registry = LocateRegistry.getRegistry(NetworkProperties.serverIp, NetworkProperties.employeePort);
      return registry.lookup(remoteObjectName);
    }
    catch(Exception ex){
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }
}
