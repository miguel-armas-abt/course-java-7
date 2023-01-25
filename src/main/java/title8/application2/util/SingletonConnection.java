package title8.application2.util;

import static title8.application2.util.constant.Constant.DATABASE_PROPERTIES_FILE;
import static title8.application2.util.constant.Constant.CONNECTION_POOL_PROPERTIES_FILE;

import title4.application.util.PropertiesReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class SingletonConnection {

  private Vector<Connection> freeConnections;
  private Vector<Connection> usedConnections;

  private String url;
  private String driver;
  private String user;
  private String password;

  private int minimumSize;
  private int maximumSize;
  private int steep;

  private static SingletonConnection connectionPool;

  private SingletonConnection() {
    try {
      String driver = PropertiesReader.getProperty("driver", DATABASE_PROPERTIES_FILE);
      String url = PropertiesReader.getProperty("url", DATABASE_PROPERTIES_FILE);
      String password = PropertiesReader.getProperty("password", DATABASE_PROPERTIES_FILE);
      String user = PropertiesReader.getProperty("user", DATABASE_PROPERTIES_FILE);

      Class.forName(driver);

      minimumSize = Integer.parseInt(PropertiesReader.getProperty("minimumSize", CONNECTION_POOL_PROPERTIES_FILE));
      maximumSize = Integer.parseInt(PropertiesReader.getProperty("maximumSize", CONNECTION_POOL_PROPERTIES_FILE));
      steep = Integer.parseInt(PropertiesReader.getProperty("steep", CONNECTION_POOL_PROPERTIES_FILE));

      freeConnections = new Vector<>();
      usedConnections = new Vector<>();

      this.instance(minimumSize);

    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }

  public synchronized static SingletonConnection getConnectionPool() {
    if (connectionPool == null) {
      connectionPool = new SingletonConnection();
    }
    return connectionPool;
  }

  public Connection getConnection() {
    if (freeConnections.size() == 0) {
      if (!createConnection())
        throw new RuntimeException("No hay más conexiones disponibles.");
    }
    Connection con = freeConnections.remove(0);
    usedConnections.add(con);
    return con;
  }

  private void instance(int connectionsNumber) {
    try {
      Connection actualConnection;
      for (int i = 0; i < connectionsNumber; i++) {
        actualConnection = DriverManager.getConnection(url, user, password);
        actualConnection.setAutoCommit(false);
        freeConnections.add(actualConnection);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

  private boolean createConnection() {
    int actualConnections = freeConnections.size() + usedConnections.size();
    int newConnections = Math.min(maximumSize - actualConnections, steep);
    if (newConnections > 0) {
      System.out.println("Creando " + newConnections + " conexiones nuevas...");
      instance(newConnections);
    }
    return newConnections > 0;
  }

  public synchronized void releaseConnection(Connection connection) {
    if (usedConnections.remove(connection)) {
      freeConnections.add(connection);
    } else
      throw new RuntimeException("Se intenta liberar una conexión ajena.");
  }

  public synchronized void closeConnections() {
    try {
      for (Connection connection : freeConnections) {
        connection.close();
      }
      for (Connection connection : usedConnections)
        connection.close();
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

  @Override
  public String toString() {
    return "Conexiones libres: " + freeConnections.size()
        + "\nConexiones usadas: " + usedConnections.size();
  }

}
