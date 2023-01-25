package title7.networking.rpc.server.services;

import java.rmi.RemoteException;

public interface RpcService {

    public String sum(String num1, String num2);
    public String upperCaseConverter(String typedString) throws RemoteException;
}
