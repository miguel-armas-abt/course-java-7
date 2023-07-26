package title8.application.employee.infrastructure.repository;

import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.employee.infrastructure.facade.EmployeeFacade;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;

public class EmployeeRepositoryImpl implements EmployeeRepository{

  private final EmployeeFacade employeeFacade = (EmployeeFacade) ObjectFactory.build(ClassesProperties.employeeFacadeClass);

  @Override
  public List<EmployeeDto> findLatestEmployees(int quantity) {
    return employeeFacade.findLatestEmployees(quantity);
  }

  @Override
  public List<EmployeeDto> findByDepartmentCode(int departmentCode) {
    return employeeFacade.findByDepartmentCode(departmentCode);
  }
}
