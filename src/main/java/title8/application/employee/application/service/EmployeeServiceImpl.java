package title8.application.employee.application.service;

import title8.application.employee.infrastructure.repository.facade.EmployeeFacade;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;
import java.util.List;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio
 * del contexto Employee.<br/>
 */
public class EmployeeServiceImpl implements EmployeeService {

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
