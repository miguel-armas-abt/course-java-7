package title8.application.employee.infrastructure.consume.employee.repository;

import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.employee.infrastructure.consume.employee.dao.EmployeeDatabaseDAO;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;

public class EmployeeRepositoryImpl implements EmployeeRepository {

  private final EmployeeDatabaseDAO employeeDao = (EmployeeDatabaseDAO) ObjectFactory.build(ClassesProperties.EMPLOYEE_DATABASE_DAO_CLASS);

  @Override
  public List<EmployeeDto> findLatestEmployees(int quantity) {
    return employeeDao.findLatestEmployees(quantity);
  }

  @Override
  public EmployeeDto findByCode(int employeeCode) {
    return employeeDao.findByCode(employeeCode);
  }
}
