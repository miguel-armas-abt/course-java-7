package title8.application;

import title8.application.department.application.service.DepartmentService;
import title8.application.department.application.service.DepartmentServiceImpl;
import title8.application.department.infrastructure.repository.DepartmentRepositoryImpl;
import title8.application.employee.application.service.EmployeeService;
import title8.application.employee.application.service.EmployeeServiceImpl;
import title8.application.employee.infrastructure.repository.EmployeeRepositoryImpl;

public class Application {

  public static void main(String[] args) {

    DepartmentService departmentService = new DepartmentServiceImpl(new DepartmentRepositoryImpl());
    System.out.println(departmentService.findAll());

    EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeRepositoryImpl());
    System.out.println(employeeService.findByDepartmentCode(1));
  }
}
