package title8.application2;

import title8.application2.department.service.DepartmentService;
import title8.application2.department.service.impl.DepartmentServiceImpl;
import title8.application2.employee.service.EmployeeService;
import title8.application2.employee.service.impl.EmployeeServiceImpl;

public class Application {

  public static void main(String[] args) {

    DepartmentService departmentService = new DepartmentServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();

    departmentService.findAll();;
    employeeService.findByDepartmentCode();
    //    employeeService.findLatestEmployeesByDate();
  }

}
