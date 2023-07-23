package title8.application.employee.infrastructure.repository.facade;

import title8.application.employee.infrastructure.repository.database.EmployeeDao;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.infrastructure.properties.ClassesProperties;
import title8.application.infrastructure.util.ObjectFactory;
import java.util.List;

/**
 * <br/>Clase Facade que implementa los métodos necesarios para separar la lógica de acceso a datos
 * de la lógica de negocio del contexto Employee.<br/>
 */
public class EmployeeFacadeDatabase implements EmployeeFacade {

  @Override
  public List<EmployeeDto> findLatestEmployees(int quantity) {
    EmployeeDao employeeDao = (EmployeeDao) ObjectFactory.build(ClassesProperties.employeeDaoClass);
    return employeeDao.findLatestEmployees(quantity);
  }

  @Override
  public List<EmployeeDto> findByDepartmentCode(int departmentCode) {
    EmployeeDao employeeDao = (EmployeeDao) ObjectFactory.build(ClassesProperties.employeeDaoClass);
    return employeeDao.findByDepartmentCode(departmentCode);
  }
}
