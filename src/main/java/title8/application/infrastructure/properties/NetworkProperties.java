package title8.application.infrastructure.properties;

import title8.application.infrastructure.constant.FileConstant;
import title8.application.infrastructure.util.PropertiesReader;

public class NetworkProperties {

  private NetworkProperties() {}

  public static int departmentPort = Integer.parseInt(PropertiesReader.getProperty("department-port", FileConstant.NETWORK_FILE));
  public static int employeePort = Integer.parseInt(PropertiesReader.getProperty("employee-port", FileConstant.NETWORK_FILE));
  public static String serverIp = PropertiesReader.getProperty("server-ip", FileConstant.NETWORK_FILE);
}
