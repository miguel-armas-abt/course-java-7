package title4.application.employee.facade.impl;

import static title4.application.util.constant.Constant.EMPLOYEE_DAO_CLASS;

import title4.application.employee.dao.EmployeeDao;
import title4.application.employee.facade.EmployeeFacade;
import title4.application.employee.model.EmployeeDto;
import title4.application.util.Factory;
import java.util.List;

/**
 * <br/>Clase Facade que implementa los métodos necesarios para separar la lógica de acceso a datos
 * de la lógica de negocio del contexto Employee.<br/>
 *
 * <b>Class</b>: EmployeeFacadeImpl<br/>
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
public class EmployeeFacadeImpl implements EmployeeFacade {

  @Override
  public List<EmployeeDto> findLatestEmployeesByDate(int latest) {
    EmployeeDao employeeDao = (EmployeeDao) Factory.build(EMPLOYEE_DAO_CLASS);
    return employeeDao.findLatestEmployees(latest);
  }

  @Override
  public List<EmployeeDto> findByDepartmentCode(int departmentCode) {
    EmployeeDao employeeDao = (EmployeeDao) Factory.build(EMPLOYEE_DAO_CLASS);
    return employeeDao.findByDepartmentCode(departmentCode);
  }
}
