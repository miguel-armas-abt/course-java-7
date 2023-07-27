package title8.application.employee.infrastructure.consume.department.dao;

import title8.application.infrastructure.properties.NetworkProperties;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DepartmentRMIDAO {

  public static Object getRemoteObject(String remoteObjectName){
    try{
      Registry registry = LocateRegistry.getRegistry(NetworkProperties.SERVER_IP, NetworkProperties.DEPARTMENTS_RMI_SERVICE_PORT);
      return registry.lookup(remoteObjectName);
    }
    catch(Exception ex){
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }
}
