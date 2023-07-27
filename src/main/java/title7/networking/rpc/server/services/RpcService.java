package title7.networking.rpc.server.services;

import java.rmi.RemoteException;

public interface RpcService {

    String sum(String num1, String num2);
    String upperCaseConverter(String typedString) throws RemoteException;
}
