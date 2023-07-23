package title8.application.employee.infrastructure.repository.facade;

import title8.application.employee.domain.model.EmployeeDto;

import java.util.List;

/**
 * <br/>Interface Facade que define los métodos necesarios para separar la lógica de acceso a datos
 * de la lógica de negocio del contexto Employee.<br/>
 */
public interface EmployeeFacade {

  List<EmployeeDto> findLatestEmployees(int latest);

  List<EmployeeDto> findByDepartmentCode(int departmentCode);

}
