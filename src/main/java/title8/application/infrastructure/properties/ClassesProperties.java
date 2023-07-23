package title8.application.infrastructure.properties;

import title8.application.infrastructure.constant.FileConstant;
import title8.application.infrastructure.util.PropertiesReader;

public class ClassesProperties {

  private ClassesProperties() {}

  public static String employeeDaoClass = PropertiesReader.getProperty("employeeDaoClass", FileConstant.FACTORY_FILE);
  public static String departmentDaoClass = PropertiesReader.getProperty("departmentDaoClass", FileConstant.FACTORY_FILE);
  public static String employeeFacadeClass = PropertiesReader.getProperty("employeeFacadeClass", FileConstant.FACTORY_FILE);
  public static String departmentFacadeClass = PropertiesReader.getProperty("departmentFacadeClass", FileConstant.FACTORY_FILE);
}
