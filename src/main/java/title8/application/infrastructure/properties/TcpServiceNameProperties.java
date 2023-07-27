package title8.application.infrastructure.properties;

import title8.application.infrastructure.constant.FileConstant;
import title8.application.infrastructure.util.PropertiesReader;

public class TcpServiceNameProperties {

  private TcpServiceNameProperties() {}

  public static final int DEPARTMENTS_FIND_ALL = Integer.parseInt(PropertiesReader.getProperty("departments-find-all", FileConstant.TCP_SERVICES_FILE));
  public static final int DEPARTMENTS_FIND_BY_CODE = Integer.parseInt(PropertiesReader.getProperty("departments-find-by-code", FileConstant.TCP_SERVICES_FILE));

}
