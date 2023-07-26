package title8.application.employee.infrastructure.facade;

import title8.application.employee.domain.model.EmployeeDto;

import java.util.List;

public interface EmployeeFacade {

  List<EmployeeDto> findLatestEmployees(int latest);

  List<EmployeeDto> findByDepartmentCode(int departmentCode);

}
