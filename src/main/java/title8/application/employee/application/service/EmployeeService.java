package title8.application.employee.application.service;

import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;

public interface EmployeeService {

  List<EmployeeDto> findLatestEmployees(int quantity);

  List<EmployeeDto> findByDepartmentCode(int departmentCode);
}
