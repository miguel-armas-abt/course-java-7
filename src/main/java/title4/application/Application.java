package title4.application;

import title4.application.department.service.DepartmentService;
import title4.application.department.service.impl.DepartmentServiceImpl;
import title4.application.employee.service.EmployeeService;
import title4.application.employee.service.impl.EmployeeServiceImpl;

public class Application {

  public static void main(String[] args) {

    DepartmentService departmentService = new DepartmentServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();

    departmentService.findAll();;
    employeeService.findByDepartmentCode();
    employeeService.findLatestEmployeesByDate();
  }

}
