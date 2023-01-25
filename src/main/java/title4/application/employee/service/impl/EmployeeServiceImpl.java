package title4.application.employee.service.impl;

import title4.application.employee.facade.EmployeeFacade;
import title4.application.employee.facade.impl.EmployeeFacadeImpl;
import title4.application.employee.model.EmployeeDto;
import title4.application.employee.service.EmployeeService;
import java.util.List;
import java.util.Scanner;

/**
 * <br/>Clase Service que implementa los métodos necesarios para tramitar la lógica de negocio
 * del contexto Employee.<br/>
 *
 * <b>Class</b>: EmployeeServiceImpl<br/>
 *
 * @author Miguel Armas Abt <br/>
 *      <u>Developed by</u>: <br/>
 *      <ul>
 *      <li>Miguel Armas Abt</li>
 *      </ul>
 *      <u>Changes</u>:<br/>
 *      <ul>
 *      <li>Set, 2021 Creación de Clase.</li>
 *      </ul>
 * @version 1.0
 */
public class EmployeeServiceImpl implements EmployeeService {

  private Scanner scanner = new Scanner(System.in);
  private EmployeeFacade employeeFacade = new EmployeeFacadeImpl();

  @Override
  public void findLatestEmployeesByDate() {
    System.out.print("Ingrese el número de empleados: ");
    int latestEmployees = scanner.nextInt();

    List<EmployeeDto> employeeList = employeeFacade.findLatestEmployeesByDate(latestEmployees);
    for (EmployeeDto employee: employeeList) {
      System.out.println(employee.toString());
    }
  }

  @Override
  public void findByDepartmentCode() {
    System.out.print("Ingrese el código de departamento: ");
    int departmentCode = scanner.nextInt();

    List<EmployeeDto> employeeList = employeeFacade.findByDepartmentCode(departmentCode);
    for (EmployeeDto employee: employeeList) {
      System.out.println(employee.toString());
    }
  }
}
