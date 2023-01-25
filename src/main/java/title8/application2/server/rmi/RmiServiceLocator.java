package title8.application2.server.rmi;

import static title7.networking.util.NetworkingConstant.SERVER_IP;
import static title7.networking.util.NetworkingConstant.SERVER_PORT;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * No será necesario encapsular la invocación a un método (o servicio) porque podemos invocarlo directamente.
 * El ServiceLocatorRMI se limitará a lookup (búsqueda) del registro y a retornar la instancia del objeto remoto.
 */
public class RmiServiceLocator {

  public static Object getObjetoRemoto(String remoteObjectName){
    try{
      Registry registry = LocateRegistry.getRegistry(SERVER_IP, SERVER_PORT);
      return registry.lookup(remoteObjectName);
    }
    catch(Exception ex){
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }
}
