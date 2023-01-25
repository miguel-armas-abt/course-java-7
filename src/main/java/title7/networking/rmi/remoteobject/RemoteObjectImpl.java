package title7.networking.rmi.remoteobject;

import title7.networking.util.UtilFunctions;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObjectImpl extends UnicastRemoteObject implements RemoteObject{

    public RemoteObjectImpl()throws RemoteException{
        super();
    }

    public String getIpServer() throws RemoteException {
        return UtilFunctions.getIpServer();
    }

    public String upperCaseConverter(String string) throws RemoteException {
        return UtilFunctions.upperCaseConverter(string);
    }

    @Override
    public int add(int firstNumber, int secondNumber) throws RemoteException {
        return UtilFunctions.add(firstNumber, secondNumber);
    }
}