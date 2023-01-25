package title7.networking.rmi.server;

import static title7.networking.util.NetworkingConstant.SERVER_PORT;

import title7.networking.rmi.remoteobject.RemoteObjectImpl;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {

  public static void main(String[] args) throws Exception {

    RemoteObjectImpl remoteObject = new RemoteObjectImpl();
    Registry registry = LocateRegistry.createRegistry(SERVER_PORT); // creo el rmiregistry al que podrán acceder los clientes

    System.out.println("RMI SERVER IS RUNNING...\n=========================");
    registry.rebind("remoteObject", remoteObject); // publico el objeto remoto con clave "remoteObject" en el rmiregistry
  }
}
