package title7.networking.rmi.remoteobject;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Los métodos de los objetos remotos deben prever la posibilidad de que ocurra una excepción de tipo RemoteException.
 */
public interface RemoteObject extends Remote {

  String getIpServer() throws RemoteException;

  String upperCaseConverter(String string) throws RemoteException;

  int add(int firstNumber, int secondNumber) throws RemoteException;

}