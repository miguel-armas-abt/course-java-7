package title8.application.infrastructure.properties;

import title8.application.infrastructure.constant.FileConstant;
import title8.application.infrastructure.util.PropertiesReader;

public class TcpServiceNameProperties {

  private TcpServiceNameProperties() {}

  public static final int numberOfFindAllDepartments = Integer.parseInt(PropertiesReader.getProperty("department-findAllDepartments", FileConstant.TCP_SERVICES_FILE));
  public static final int numberOfFindEmployeesByDepartmentCode = Integer.parseInt(PropertiesReader.getProperty("employee-findByDepartmentCode", FileConstant.TCP_SERVICES_FILE));

}
