package title4.application.util;

import static title4.application.util.constant.Constant.DATABASE_PROPERTIES_FILE;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

  private static Connection instance = null;

  public static Connection getConnection() {
    try {
      if (instance == null) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());

        String driver = PropertiesReader.getProperty("driver", DATABASE_PROPERTIES_FILE);
        String url = PropertiesReader.getProperty("url", DATABASE_PROPERTIES_FILE);
        String password = PropertiesReader.getProperty("password", DATABASE_PROPERTIES_FILE);
        String user = PropertiesReader.getProperty("user", DATABASE_PROPERTIES_FILE);

        Class.forName(driver);
        instance = DriverManager.getConnection(url, user, password);
      }
      return instance;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException();
    }
  }

  /**
   * En caso de alguna interrupción el método run se ejecutará igualmente.
   */
  static class ShutdownHook extends Thread {
    public void run() {
      try {
        Connection connection = SingletonConnection.getConnection();
        connection.close();
      } catch (Exception exception) {
        exception.printStackTrace();
        throw new RuntimeException();
      }
    }
  }

}
