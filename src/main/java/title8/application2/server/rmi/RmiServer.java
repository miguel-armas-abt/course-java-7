package title8.application2.server.rmi;

import static title7.networking.util.NetworkingConstant.SERVER_PORT;
import static title8.application2.util.constant.Constant.REMOTE_OBJECT;

import title8.application2.server.rmi.remotefacade.RemoteRmiFacade;
import title8.application2.server.rmi.remotefacade.impl.RemoteRmiFacadeImpl;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {

  public static void main(String[] args) throws RemoteException {

    RemoteRmiFacade remoteFacade = new RemoteRmiFacadeImpl();

    try {
      String ip = InetAddress.getLocalHost().toString();
      System.out.println("Server connected: " + ip);
    } catch (Exception ex) {
    }

    Registry registry = LocateRegistry.createRegistry(SERVER_PORT);
    registry.rebind(REMOTE_OBJECT, remoteFacade);
  }
}
