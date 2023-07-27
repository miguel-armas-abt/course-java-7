package title8.application;

import title8.application.employee.application.service.EmployeeService;
import title8.application.employee.application.service.EmployeeServiceImpl;
import title8.application.employee.infrastructure.consume.department.repository.DepartmentRepositoryImpl;
import title8.application.employee.infrastructure.consume.employee.repository.EmployeeRepositoryImpl;

public class Application {

  public static void main(String[] args) {
    EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeRepositoryImpl(), new DepartmentRepositoryImpl());
    System.out.println(employeeService.findEmployeeLocation(8));
  }
}
