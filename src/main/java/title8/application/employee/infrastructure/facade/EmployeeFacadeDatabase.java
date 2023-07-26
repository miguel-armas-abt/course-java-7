package title8.application.employee.infrastructure.facade;

import java.util.List;
import title8.application.employee.infrastructure.dao.EmployeeDatabaseDAO;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;

public class EmployeeFacadeDatabase implements EmployeeFacade {

  @Override
  public List<EmployeeDto> findLatestEmployees(int quantity) {
    EmployeeDatabaseDAO employeeDao = (EmployeeDatabaseDAO) ObjectFactory.build(ClassesProperties.employeeDaoClass);
    return employeeDao.findLatestEmployees(quantity);
  }

  @Override
  public List<EmployeeDto> findByDepartmentCode(int departmentCode) {
    EmployeeDatabaseDAO employeeDao = (EmployeeDatabaseDAO) ObjectFactory.build(ClassesProperties.employeeDaoClass);
    return employeeDao.findByDepartmentCode(departmentCode);
  }
}
