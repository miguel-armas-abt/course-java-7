package title8.application.employee.infrastructure.repository;

import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;

public interface EmployeeRepository {

  List<EmployeeDto> findLatestEmployees(int latest);

  List<EmployeeDto> findByDepartmentCode(int departmentCode);
}
