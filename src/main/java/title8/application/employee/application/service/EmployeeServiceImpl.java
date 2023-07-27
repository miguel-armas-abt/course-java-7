package title8.application.employee.application.service;

import java.util.List;

import title8.application.department.domain.model.DepartmentDto;
import title8.application.employee.domain.model.EmployeeDto;
import title8.application.employee.domain.model.EmployeeLocationDto;
import title8.application.employee.infrastructure.consume.department.repository.DepartmentRepository;
import title8.application.employee.infrastructure.consume.employee.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final DepartmentRepository departmentRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
    this.employeeRepository = employeeRepository;
    this.departmentRepository = departmentRepository;
  }

  @Override
  public List<EmployeeDto> findLatestEmployees(int quantity) {
    return employeeRepository.findLatestEmployees(quantity);
  }

  @Override
  public EmployeeDto findByCode(int employeeCode) {
    return employeeRepository.findByCode(employeeCode);
  }

  @Override
  public EmployeeLocationDto findEmployeeLocation(int employeeCode) {
    EmployeeDto employee = this.findByCode(employeeCode);
    DepartmentDto department = departmentRepository.findByCode(employee.getDepartmentCode());

    EmployeeLocationDto employeeLocation = new EmployeeLocationDto();
    employeeLocation.setCode(employee.getCode());
    employeeLocation.setName(employee.getName());
    employeeLocation.setLocation(department.getLocation());

    return employeeLocation;
  }
}
