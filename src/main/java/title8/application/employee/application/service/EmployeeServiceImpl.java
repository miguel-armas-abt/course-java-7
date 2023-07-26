package title8.application.employee.application.service;

import java.util.List;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.employee.infrastructure.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<EmployeeDto> findLatestEmployees(int quantity) {
    return employeeRepository.findLatestEmployees(quantity);
  }

  @Override
  public List<EmployeeDto> findByDepartmentCode(int departmentCode) {
    return employeeRepository.findByDepartmentCode(departmentCode);
  }
}
