package title7.networking.rpc.server;

import static title7.networking.util.NetworkingConstant.SERVER_PORT;

import org.apache.xmlrpc.WebServer;
import title7.networking.rpc.server.services.RpcService;
import title7.networking.rpc.server.services.RpcServiceImpl;
import javax.swing.*;

public class RpcServer {

  public static void main(String[] args) {

    try {
      WebServer server = new WebServer(SERVER_PORT); // punto final para comunicacion con el server
      RpcService rpcService = new RpcServiceImpl();
      server.addHandler("myRpcServer", rpcService); // se asigna un identificador al servidor
      server.start();
      JOptionPane.showMessageDialog(null, "RPC SERVER IS RUNNING...");

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
    }
  }

}