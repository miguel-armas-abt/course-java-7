package title7.networking.rpc.server;

import static title7.networking.util.NetworkingConstant.RPC_SERVER_PORT;

import org.apache.xmlrpc.WebServer;
import title7.networking.rpc.server.services.RpcService;
import title7.networking.rpc.server.services.RpcServiceImpl;

public class RpcServer {

  public static void main(String[] args) {

    try {
      WebServer server = new WebServer(RPC_SERVER_PORT);
      RpcService rpcService = new RpcServiceImpl();
      server.addHandler("myRpcServer", rpcService); //se asigna un identificador al servidor
      server.start();
      System.out.println("You have connected to RPC server.");
    } catch (Exception exception) {
      throw new RuntimeException("error to connect to RPC Server: " + exception.getMessage());
    }
  }

}
