package title8.application.infrastructure.properties;

import title8.application.infrastructure.constant.FileConstant;
import title8.application.infrastructure.util.PropertiesReader;

public class ClassesProperties {

  private ClassesProperties() {}

  public static String EMPLOYEE_DATABASE_DAO_CLASS = PropertiesReader.getProperty("employeeDatabaseDaoClass", FileConstant.SELECTOR_CLASS_FILE);
  public static String DEPARTMENT_DATABASE_DAO_CLASS = PropertiesReader.getProperty("departmentDatabaseDaoClass", FileConstant.SELECTOR_CLASS_FILE);
  public static String DEPARTMENT_FACADE_CLASS = PropertiesReader.getProperty("departmentFacadeClass", FileConstant.SELECTOR_CLASS_FILE);
}
