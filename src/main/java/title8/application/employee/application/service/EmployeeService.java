package title8.application.employee.application.service;

import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.employee.domain.model.EmployeeLocationDto;

public interface EmployeeService {

  List<EmployeeDto> findLatestEmployees(int quantity);

  EmployeeDto findByCode(int employeeCode);

  EmployeeLocationDto findEmployeeLocation(int employeeCode);
}
