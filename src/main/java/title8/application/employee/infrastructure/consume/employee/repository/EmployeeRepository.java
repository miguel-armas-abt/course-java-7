package title8.application.employee.infrastructure.consume.employee.repository;

import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;

public interface EmployeeRepository {

  List<EmployeeDto> findLatestEmployees(int latest);

  EmployeeDto findByCode(int employeeCode);
}
