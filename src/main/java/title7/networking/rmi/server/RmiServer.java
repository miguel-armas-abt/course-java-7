package title7.networking.rmi.server;

import static title7.networking.util.NetworkingConstant.RMI_SERVER_PORT;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {

  public static void main(String[] args) throws Exception {

    RemoteObjectImpl remoteObject = new RemoteObjectImpl();
    Registry registry = LocateRegistry.createRegistry(RMI_SERVER_PORT); //creo el registro RMI
    registry.rebind("remoteObject", remoteObject); //publico el objeto remoto "remoteObject" en el rmiregistry
    System.out.println("You have connected to RMI server.");
  }
}
