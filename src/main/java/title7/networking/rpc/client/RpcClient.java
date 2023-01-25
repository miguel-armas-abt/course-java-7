package title7.networking.rpc.client;

import static title7.networking.util.NetworkingConstant.SERVER_IP;
import static title7.networking.util.NetworkingConstant.SERVER_PORT;

import org.apache.xmlrpc.XmlRpcClient;
import javax.swing.*;
import java.util.Vector;

public class RpcClient {

  public static void main(String[] args) {
    String num1 = "";
    String num2 = "";
    String cadena = "";
    Object response;

    try {
      // conexion y hacer referencia al ip server
      XmlRpcClient client = new XmlRpcClient("http://" + SERVER_IP + ":" + SERVER_PORT);
      JOptionPane.showMessageDialog(null, "RPC CLIENT CONNECTED...");

      // parametros que se envian al server y este inyecta en el procedimiento remoto
      Vector<String> params = new Vector<>();

      while (true) {
        String menu = JOptionPane.showInputDialog(null,
                "RPC OPERATIONS\n1. Sum\n2. Uppercase Converter \n3. Exit",
                "CLIENT", JOptionPane.DEFAULT_OPTION);
        switch (menu) {
          case "1":
            num1 = JOptionPane.showInputDialog(null, "FIRST NUMBER",
                    "SUM", JOptionPane.QUESTION_MESSAGE);
            num2 = JOptionPane.showInputDialog(null, "SECOND NUMBER",
                    "SUM", JOptionPane.QUESTION_MESSAGE);

            params.addElement(num1);
            params.addElement(num2);

            // Envia los parametros al metodo para que se ejecute y guarda lo que el servidor envíe
            response = client.execute("myRpcServer.sum", params);

            JOptionPane.showMessageDialog(null, "THE SUM IS: " + response);

            params.clear();
            break;
          case "2":
            cadena = JOptionPane.showInputDialog(null, "INSERT A SENTENCE",
                    "UPPER CASE CONVERTER", JOptionPane.QUESTION_MESSAGE);
            params.addElement(cadena);

            // Envia los parametros al metodo para que se ejecute y guarda lo que el servidor envíe
            response = client.execute("myRpcServer.upperCaseConverter", params);

            JOptionPane.showMessageDialog(null, "RESULT IS: " + response);

            params.clear();
            break;
          case "3":
            JOptionPane.showMessageDialog(null, "THANKS, COME BACK SOON!",
                        null, JOptionPane.DEFAULT_OPTION);
            System.exit(0);
            break;
          default: JOptionPane.showMessageDialog(null, "INSERT ANOTHER NUMBER",
                  "UPS!", JOptionPane.WARNING_MESSAGE);
        }
      }

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
    }
  }
}