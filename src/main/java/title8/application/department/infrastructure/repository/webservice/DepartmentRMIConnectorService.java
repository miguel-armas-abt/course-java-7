package title8.application.department.infrastructure.repository.webservice;

import title8.application.infrastructure.properties.NetworkProperties;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DepartmentRMIConnectorService {

  public static Object getRemoteObject(String remoteObjectName){
    try{
      Registry registry = LocateRegistry.getRegistry(NetworkProperties.serverIp, NetworkProperties.departmentPort);
      return registry.lookup(remoteObjectName);
    }
    catch(Exception ex){
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }
}
